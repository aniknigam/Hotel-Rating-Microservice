package com.lcdw.hotel.repository;

import com.lcdw.hotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, String> {
//    Optional<Hotel> findById();
}
