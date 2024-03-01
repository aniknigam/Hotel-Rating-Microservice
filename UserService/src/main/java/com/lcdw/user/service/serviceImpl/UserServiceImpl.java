package com.lcdw.user.service.serviceImpl;

import com.lcdw.user.service.entities.Hotel;
import com.lcdw.user.service.entities.Ratings;
import com.lcdw.user.service.entities.Users;
import com.lcdw.user.service.excepiton.ResourceNotFoundException;
import com.lcdw.user.service.repository.UserRepository;
import com.lcdw.user.service.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;



    @Override
    public Users saveUser(Users usrs) {
        String create =   UUID.randomUUID().toString();
        usrs.setUserId(create);
        return userRepository.save(usrs);
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users getUser(String uId) {
        //rating url
        //http://localhost:8084/ratings/user/uid

        Users user =  userRepository.findById(uId).orElseThrow(() -> new ResourceNotFoundException("User with id not found"));
        Ratings[] data = restTemplate.getForObject("http://localhost:8084/ratings/user/"+uId, Ratings[].class);
        System.out.println(data);

        List<Ratings> rating = Arrays.stream(data).toList();

        List<Ratings> ratingsList = rating.stream().map( ratings -> {
            /*
            * Steps
            * 1. api call to hotel service to get the hotel
            * 2. set the hotel to rating
            * 3. return the rating
            * */
          String getHotelByidUrl = "http://localhost:8081/hotels/getHotel/"+ ratings.getHotelId();
        //    String getHotelByidUrl = "http://localhost:8081/hotels/getHotel/5b8d4832-5ba7-4d84-b65f-c10566d89c49";
            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity(getHotelByidUrl, Hotel.class);
            Hotel hotel = forEntity.getBody();
            ratings.setHotel(hotel);
            return  ratings;
        }).collect(Collectors.toList());

        user.setRatings(ratingsList);

        return user;
    }

    @Override
    public Users updateUser(Users user) {
        Users update = new Users();
        update.setName(user.getName());
        update.setEmail(user.getEmail());
        update.setAbout(user.getAbout());
        Users  saved = userRepository.save(update);
        return saved;
    }

    @Override
    public void delete(String userid) {
     userRepository.deleteById(userid);
    }
}
