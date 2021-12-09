package com.zhen.mypersonalshop.Controller;

import com.zhen.mypersonalshop.Model.User;
import com.zhen.mypersonalshop.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    UserService userService;


    //fetch user from database using the value /users/{userId}. will throw a 404 response if userId not found.
    @GetMapping(value = {"/users/{userId}"})
    public ResponseEntity<?> getUser(@PathVariable int userId){
        User user = userService.getUser(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //fetch all users from database
    @GetMapping(value = "/users")
    public ResponseEntity<?> getAllUser()
    {
        List<User> userList = userService.getAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    //create and save user to database. If user already exist then it will return null.
    @PostMapping(value = "/users")
    public ResponseEntity<?> createUser(@RequestBody User user)
    {
//        try{
//            userService.saveUser(user);
//        }
//
//        //make more specific exception SQLException
//        catch (Exception e) {
//            return null;
//        }
//        return user;
    }

    //update user base on userID
    @PutMapping(value={"/users/{userId}"})
    public ResponseEntity<?> updateAccount(@PathVariable int userId, @RequestBody User user)
    {
        User u = userService.getUser(userId);
        u.setUsername(user.getUsername());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        return userService.saveUser(u);
    }

    //delete user base of the input userID
    @DeleteMapping(value={"/users/{userId}"})
    public void deleteAccount(@PathVariable int userId)
    {
        userService.deleteAccount(userId);
    }


}
