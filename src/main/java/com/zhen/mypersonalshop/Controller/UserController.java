package com.zhen.mypersonalshop.Controller;

import com.zhen.mypersonalshop.Model.User;
import com.zhen.mypersonalshop.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@RestController
public class UserController {

    @Autowired
    UserService userService;


    //fetch user from database using the value /users/{userId}. will throw a 404 response if userId not found.
    @GetMapping(value = {"/users/{userId}"})
    public User getUser(@PathVariable int userId){
        Optional<User> user = userService.getUser(userId);
        if(user.isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "404 user not in database!");
        }
        return user.get();
    }

    //fetch all users from database
    @GetMapping(value = "/users")
    public Iterable<User> getAllUser()
    {
        return userService.getAllUsers();
    }

    //create and save user to database. If user already exist then it will return null.
    @PostMapping(value = "/users")
    public User createUser(@RequestBody User user)
    {
        try{
            userService.saveOrCreateAccount(user);
        }

        //make more specific exception SQLException
        catch (Exception e) {
            return null;
        }
        return user;
    }

    //update user base on userID
    @PutMapping(value={"/users/{userId}"})
    public User updateAccount(@PathVariable int userId, @RequestBody User user)
    {
        Optional<User> userOptional = userService.getUser(userId);
        User u = userOptional.get();
        u.setUsername(user.getUsername());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        return userService.saveOrCreateAccount(u);
    }

    //delete user base of the input userID
    @DeleteMapping(value={"/users/{userId}"})
    public void deleteAccount(@PathVariable int userId)
    {
        userService.deleteAccount(userId);
    }


}
