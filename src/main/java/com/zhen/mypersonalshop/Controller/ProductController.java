package com.zhen.mypersonalshop.Controller;

import com.zhen.mypersonalshop.Model.Product;
import com.zhen.mypersonalshop.Model.User;
import com.zhen.mypersonalshop.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    //fetch user from database using the value /users/{userId}. will throw a 404 response if userId not found.
//    @GetMapping(value = {"/users/{userId}"})
//    public User getUser(@PathVariable int userId){
//        Optional<User> user = userService.getUser(userId);
//        if(user.isEmpty())
//        {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "404 user not in database!");
//        }
//        return user.get();
//    }

    @GetMapping(value = {"/products/{productId}"})
    public Product getProduct(@PathVariable int productId)
    {
        Optional<Product> product = productService.getProduct(productId);
        if(product.isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "404 product not in database!");
        }
        return product.get();
    }
}
