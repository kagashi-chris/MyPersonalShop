package com.zhen.mypersonalshop.Service;

import com.zhen.mypersonalshop.Model.Cart;
import com.zhen.mypersonalshop.Model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CartService {

    public Cart addOrUpdateCart(Cart cart);
    public Optional<Cart> getCart(int id);
    public Iterable<Cart> getAllUsers();
    public void deleteCart(int id);

}
