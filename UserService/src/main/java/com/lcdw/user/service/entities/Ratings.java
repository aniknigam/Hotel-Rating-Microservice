package com.lcdw.user.service.entities;

import lombok.Data;

@Data
public class Ratings {
    private String ratingId;
    private String userId;
    private String hotelId;
    private String feedback;
    private int rating;
}
