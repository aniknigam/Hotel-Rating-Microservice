package com.lcdw.rating.serviceImpl;

import com.lcdw.rating.entity.Rating;
import com.lcdw.rating.repository.RatingRespository;
import com.lcdw.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRespository ratingRespository;
    @Override
    public Rating create(Rating rating) {
        return ratingRespository.save(rating);
    }

    @Override
    public List<Rating> allRating() {
        return ratingRespository.findAll();
    }

    @Override
    public List<Rating> listOfRatingByUserId(String userId) {

        List<Rating> rating  = ratingRespository.findByUserId(userId);
        System.out.println(rating.toString());
        return rating;
    }

    @Override
    public List<Rating> listOfRatingByhotelId(String hotelId) {
        return ratingRespository.findByHotelId(hotelId);
    }
}
