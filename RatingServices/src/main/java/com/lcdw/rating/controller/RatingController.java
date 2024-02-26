package com.lcdw.rating.controller;

import com.lcdw.rating.entity.Rating;
import com.lcdw.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    RatingService ratingservice;

    @PostMapping("/create")
    public Rating createRating(@RequestBody Rating rating) {
        return ratingservice.create(rating);
    }

    @GetMapping("/all")
    public List<Rating> getAllRatings() {
        return ratingservice.allRating();
    }

    @GetMapping("/user/{userId}")
    public List<Rating> getRatingsByUserId(@PathVariable String userId) {
        return ratingservice.listOfRatingByUserId(userId);
    }

    @GetMapping("/hotel/{hotelId}")
    public List<Rating> getRatingsByHotelId(@PathVariable String hotelId) {
        return ratingservice.listOfRatingByhotelId(hotelId);
    }
}
