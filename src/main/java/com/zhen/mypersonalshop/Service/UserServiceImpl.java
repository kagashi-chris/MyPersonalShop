package com.zhen.mypersonalshop.Service;

import com.zhen.mypersonalshop.Model.User;
import com.zhen.mypersonalshop.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveOrCreateAccount(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUser(int id) {
        return userRepository.findById(id);
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteAccount(int id) {
        userRepository.deleteById(id);
    }
}
