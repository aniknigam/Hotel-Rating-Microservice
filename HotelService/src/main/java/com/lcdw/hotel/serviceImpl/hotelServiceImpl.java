package com.lcdw.hotel.serviceImpl;

import com.lcdw.hotel.entity.Hotel;
import com.lcdw.hotel.exception.ResourceNotFoundException;
import com.lcdw.hotel.repository.HotelRepository;
import com.lcdw.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class hotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;
    @Override
    public Hotel create(Hotel hotel) {
      String create =   UUID.randomUUID().toString();
      hotel.setId(create);
      return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));
    }
}
