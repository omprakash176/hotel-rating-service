package com.user.servies.UserService.com.user.controller;


import com.user.servies.UserService.com.user.entities.User;
import com.user.servies.UserService.com.user.servies.UserServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServies userServies;

    @PostMapping("/create-user")
    public ResponseEntity<User> createUser(@RequestBody User user) {

        User savedUser = userServies.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping("/get-user/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
        User user = userServies.getUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/all-User")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> usersList = userServies.getallusers();
        return ResponseEntity.status(HttpStatus.OK).body(usersList);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateRating(@RequestBody User userargs)  {
        User user = userServies.updateUser(userargs);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<User>deleteUser(@PathVariable String userId) {
        User user = (userServies.getUserById(userId));
        if(user!=null)
        {
            userServies.deleteUser(userId);
        }
        return  ResponseEntity.status(HttpStatus.OK).body(user);
    }



}