package com.lcdw.hotel.controller;

import com.lcdw.hotel.entity.Hotel;
import com.lcdw.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/save")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel createdHotel = hotelService.create(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHotel);
    }

    @GetMapping("/getAllHotels")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelService.getAllHotel();
        return ResponseEntity.ok().body(hotels);
    }

    @GetMapping("/getHotel/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String id) {
        Hotel hotel = hotelService.get(id);
        return ResponseEntity.ok().body(hotel);
    }

    // Add other endpoints for update, delete, etc. if needed
}
