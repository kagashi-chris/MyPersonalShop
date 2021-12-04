package com.zhen.mypersonalshop.Service;

import com.zhen.mypersonalshop.Model.Cart;
import com.zhen.mypersonalshop.Model.Product;
import com.zhen.mypersonalshop.Model.User;
import com.zhen.mypersonalshop.Repository.CartRepository;
import com.zhen.mypersonalshop.Repository.ProductRepository;
import com.zhen.mypersonalshop.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.Optional;

public class CartServiceImpl implements CartService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;


    //gets the user and product using their ID. Throw resource not found exception if empty.
    @Override
    public Cart addToCart(int userId, int productId) {
        Optional<User> u = userRepository.findById(userId);
        if(!u.isPresent())
        {
            throw new ResourceNotFoundException("user id " + userId + " not found!");
        }
        Optional<Product> p = productRepository.findById(productId);
        if(!p.isPresent())
        {
            throw new ResourceNotFoundException("product id " + productId + " not found!");
        }

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
