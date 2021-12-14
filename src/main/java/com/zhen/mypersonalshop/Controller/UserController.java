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

import javax.validation.Valid;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    /**
     * checks if database already has a user with the same email or username. If not then it will proceed to create
     * and save a new user to the database
     * @param user
     * @return
     */
    @PostMapping(value = "/users")
    public ResponseEntity<?> createUser(@Valid @RequestBody User user)
    {
        User newUser = userService.saveUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

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


    /**
     * first checks if user with userId exist in data then update user base on whatever information is added
     * @param userId
     * @param user
     * @return ResponseEntity with User and HttpStatus OK
     */
    @PutMapping(value={"/users/{userId}"})
    public ResponseEntity<?> updateAccount(@PathVariable long userId, @Valid @RequestBody User user)
    {
        User activeUser = userService.updateUser(user,userId);
        return new ResponseEntity<>(activeUser, HttpStatus.OK);
    }

    //delete user base of the input userID
    @DeleteMapping(value={"/users/{userId}"})
    public void deleteAccount(@PathVariable int userId)
    {
        User activeUser = userService.getUser(userId);
        userService.deleteAccount(userId);
    }


}
