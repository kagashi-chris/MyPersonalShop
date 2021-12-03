package com.zhen.mypersonalshop.Service;

import com.zhen.mypersonalshop.Model.Cart;
import com.zhen.mypersonalshop.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart addOrUpdateCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Optional<Cart> getCart(int id) {
        return cartRepository.findById(id);
    }

    @Override
    public Iterable<Cart> getAllUsers() {
        return cartRepository.findAll();
    }

    @Override
    public void deleteCart(int id) {
        cartRepository.deleteById(id);
    }
}
