package com.lcdw.user.service.controller;

import com.lcdw.user.service.entities.Users;
import com.lcdw.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<Users> addUsers(@RequestBody Users users) {
        String id = UUID.randomUUID().toString();

        Users saveUser = userService.saveUser(users);
        return new ResponseEntity<Users>(saveUser, HttpStatus.OK);
    }

    @GetMapping("/allusers")
    public ResponseEntity<List<Users>> allUsers() {
       List<Users> all = userService.getAllUsers();
       return new ResponseEntity<List<Users>>(all, HttpStatus.OK);
    }

    @GetMapping("/getSingleUser/{userId}")
    public ResponseEntity<Users> getSingleUser(@PathVariable String userId) {
        Users singleUser = userService.getUser(userId);
        return new ResponseEntity<Users>(singleUser, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {
        userService.delete(userId);
        return ResponseEntity.status(HttpStatus.OK).body("User Data Deleted Successfully");
    }


}
