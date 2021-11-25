package com.zhen.mypersonalshop.Controller;

import com.zhen.mypersonalshop.Model.User;
import com.zhen.mypersonalshop.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = {"/users/{userId}"})
    public User getUser(@PathVariable int userId){
        Optional<User> user = userService.getUser(userId);
        if(user.isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "404 user not in database!");
        }
        return user.get();
    }

    @PostMapping(value = "/users")
    public User createUser(@RequestBody User user)
    {
        userService.saveOrCreateAccount(user);
        return user;
    }




}
