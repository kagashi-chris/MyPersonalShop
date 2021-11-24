package com.zhen.mypersonalshop.Service;

import com.zhen.mypersonalshop.Model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {

    public User saveOrCreateAccount(User user);
    public Optional<User> getUser(int id);
    public Iterable<User> getAllUsers();
    public void deleteAccount(int id);
}
