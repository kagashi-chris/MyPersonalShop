package com.zhen.mypersonalshop.Controller;


import com.zhen.mypersonalshop.Model.Cart;
import com.zhen.mypersonalshop.Model.User;
import com.zhen.mypersonalshop.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/carts")
public class    CartController {

    @Autowired
    private CartService cartService;


    @PutMapping(value = "/add/users/{userId}/products/{productId}")
    public ResponseEntity<?> addToCart(@PathVariable long userId, @PathVariable long productId)
    {
        Cart addToCart = cartService.addToCart(userId, productId);
        return new ResponseEntity<>(addToCart, HttpStatus.OK);
    }

    @DeleteMapping(value = "/remove/users/{userId}/products/{productId}")
    public ResponseEntity<?> removeFromCart(@PathVariable long userId, @PathVariable long productId)
    {
        Cart removeFromCart = cartService.removeFromCart(userId, productId);
        return new ResponseEntity<>(removeFromCart, HttpStatus.OK);
    }


}
