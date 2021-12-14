package com.zhen.mypersonalshop.Service;

import com.zhen.mypersonalshop.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    public User saveUser(User user);
    public User getUser(long id);
    public List<User> getAllUsers();
    public User updateUser(User user, long id);
    public void deleteAccount(long id);
}
