package com.lcdw.rating.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("rating")
public class Rating {
    @Id
    private String ratingId;
    private String userId;
    private String hotelId;
    private String feedback;
    private int rating;
}
