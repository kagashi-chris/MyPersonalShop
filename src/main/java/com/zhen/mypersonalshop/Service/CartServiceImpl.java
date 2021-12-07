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
        User user = findUser(userId);
        Product product = findProduct(productId);
        Cart workingCart = cartRepository.findById(new CartId(userId, productId)).orElse(new Cart(product,user,0));
        workingCart.setAmount(workingCart.getAmount()+1);
        return cartRepository.save(workingCart);
    }

    @Override
    public Cart removeFromCart(long userId, long productId) {
        User user = findUser(userId);
        Product product = findProduct(productId);
        Cart cart = findCart(userId, productId);

        cart.setAmount(cart.getAmount()-1);
        if(cart.getAmount() <= 0)
        {
            cartRepository.deleteById(new CartId(userId,productId));
        }
        else
        {
            cartRepository.save(cart);
        }
        return cart;
    }

    private User findUser(long userId)
    {
        Optional<User> user = userRepository.findById(userId);
        if(!user.isPresent())
        {
            throw new ResourceNotFoundException("user id " + userId + " not found!");
        }
        return user.get();
    }

    private Product findProduct(long productId)
    {
        Optional<Product> product = productRepository.findById(productId);
        if(!product.isPresent())
        {
            throw new ResourceNotFoundException("product id " + productId + " not found!");
        }
        return product.get();
    }

    private Cart findCart(long userId, long productId)
    {
        Optional<Cart> cart = cartRepository.findById(new CartId(userId,productId));
        if(!cart.isPresent())
        {
            throw new ResourceNotFoundException("cart not found!");
        }
        return cart.get();
    }


}


