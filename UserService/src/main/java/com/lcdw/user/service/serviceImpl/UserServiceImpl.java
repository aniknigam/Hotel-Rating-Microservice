package com.lcdw.user.service.serviceImpl;

import com.lcdw.user.service.entities.Ratings;
import com.lcdw.user.service.entities.Users;
import com.lcdw.user.service.excepiton.ResourceNotFoundException;
import com.lcdw.user.service.repository.UserRepository;
import com.lcdw.user.service.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;



    @Override
    public Users saveUser(Users usrs) {
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
        ArrayList<Ratings> data = restTemplate.getForObject("http://localhost:8084/ratings/user/"+uId, ArrayList.class);
        System.out.println(data);
        Users user =  userRepository.findById(uId).orElseThrow(() -> new ResourceNotFoundException("User with id not found"));
        user.setRatings(data);

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
