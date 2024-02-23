package com.lcdw.user.service.serviceImpl;

import com.lcdw.user.service.entities.Users;
import com.lcdw.user.service.repository.UserRepository;
import com.lcdw.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users saveUser(Users usrs) {
        return userRepository.save(usrs);
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users getUser(String uId) {
        return null;
    }

    @Override
    public Users updateUser(Users user) {
        return null;
    }

    @Override
    public void delete(String userid) {

    }
}
