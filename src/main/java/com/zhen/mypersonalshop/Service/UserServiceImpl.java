package com.zhen.mypersonalshop.Service;

import com.zhen.mypersonalshop.Model.User;
import com.zhen.mypersonalshop.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.client.ResourceAccessException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;


    @Override
    @Transactional
    public User saveUser(User user) {
        if(user.getCart().size() >= 0)
        {
            throw new ResourceAccessException("Cart must be empty");
        }
        User newUser = new User();
        if(user.getId() != 0)
        {
            newUser = userRepository.findById(user.getId()).get();
        }
        newUser.setUsername(user.getUsername().toLowerCase());
        newUser.setEmail(user.getEmail().toLowerCase());
        newUser.setPassword(user.getPassword());
    }

    @Override
    public User getUser(long id) {

        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent())
        {
            throw new ResourceNotFoundException("user id " + id + " not found!");
        }
        return user.get();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        for(User u: userRepository.findAll())
        {
            userList.add(u);
        }
        return userList;
    }

    @Override
    @Transactional
    public void deleteAccount(long id) {
        userRepository.deleteById(id);
    }
}
