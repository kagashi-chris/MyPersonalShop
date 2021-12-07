package com.zhen.mypersonalshop.Service;

import com.zhen.mypersonalshop.Model.Cart;
import com.zhen.mypersonalshop.Model.CartId;
import com.zhen.mypersonalshop.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CartService {

    public Cart addToCart(long userId, long productId);
    public Cart removeFromCart(long userId, long productId);

}
