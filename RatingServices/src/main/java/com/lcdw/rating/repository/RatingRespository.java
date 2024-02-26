package com.lcdw.rating.repository;

import com.lcdw.rating.entity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRespository extends MongoRepository<Rating, String> {
    List<Rating> findByHotelId(String id);
    List<Rating> findByUserId(String id);
}
