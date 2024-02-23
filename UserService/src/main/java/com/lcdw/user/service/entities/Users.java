package com.lcdw.user.service.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
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

}
