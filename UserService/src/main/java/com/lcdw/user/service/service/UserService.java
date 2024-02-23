package com.lcdw.user.service.service;

import com.lcdw.user.service.entities.Users;

import java.util.List;

public interface UserService {
    Users saveUser(Users usrs);

    List<Users> getAllUsers();

    Users getUser(String uId);

    Users updateUser(Users user);

    void delete(String userid);
}
