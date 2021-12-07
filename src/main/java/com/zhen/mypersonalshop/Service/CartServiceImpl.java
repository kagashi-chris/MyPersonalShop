package com.zhen.mypersonalshop.Service;

import com.zhen.mypersonalshop.Model.Cart;
import com.zhen.mypersonalshop.Model.CartId;
import com.zhen.mypersonalshop.Model.Product;
import com.zhen.mypersonalshop.Model.User;
import com.zhen.mypersonalshop.Repository.CartRepository;
import com.zhen.mypersonalshop.Repository.ProductRepository;
import com.zhen.mypersonalshop.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;
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
    public Cart addToCart(long userId, long productId) {
        Optional<User> user = userRepository.findById(userId);
        if(!user.isPresent())
        {
            throw new ResourceNotFoundException("user id " + userId + " not found!");
        }
        Optional<Product> product = productRepository.findById(productId);
        if(!product.isPresent())
        {
            throw new ResourceNotFoundException("product id " + productId + " not found!");
        }

        Cart workingCart = cartRepository.findById(new CartId(userId, productId)).orElse(new Cart(product.get(),user.get(),0));
        workingCart.setAmount(workingCart.getAmount()+1);
        return cartRepository.save(workingCart);
    }

    @Override
    public void removeFromCart(long userId, long productId) {

    }
}


