package com.lcdw.user.service.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "user")
public class Users {
    @Id
    private String userId;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String about;

    @Transient
    private List<Ratings> ratings = new ArrayList<>();

}
