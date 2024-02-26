package com.lcdw.rating.service;

import com.lcdw.rating.entity.Rating;

import java.util.List;

public interface RatingService {
    Rating create(Rating rating);

    List<Rating> allRating();

    List<Rating> listOfRatingByUserId(String userId);

    List<Rating> listOfRatingByhotelId(String hotelId);
}
