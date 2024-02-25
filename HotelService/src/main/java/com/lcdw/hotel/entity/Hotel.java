package com.lcdw.hotel.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "hotel")
@Data
public class Hotel {

    @Id
    private String id;
    private String name;
    private String location;
    private String about;
}
