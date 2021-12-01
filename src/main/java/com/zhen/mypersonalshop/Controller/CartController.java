package com.zhen.mypersonalshop.Controller;


import com.zhen.mypersonalshop.Model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class CartController {

//    @GetMapping(value = {"/users/{userId}/cart"})
//    public User getUser(@PathVariable int userId){
//        Optional<User> user = userService.getUser(userId);
//        if(user.isEmpty())
//        {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "404 user not in database!");
//        }
//        return user.get();
//    }


}
