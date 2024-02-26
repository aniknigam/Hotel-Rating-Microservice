package com.lcdw.hotel.service;

import com.lcdw.hotel.entity.Hotel;

import java.util.List;

public interface HotelService {
    Hotel create(Hotel hotel);
    List<Hotel> getAllHotel();
    Hotel get(String id);
}
