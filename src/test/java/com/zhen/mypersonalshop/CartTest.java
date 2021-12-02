package com.zhen.mypersonalshop;

import com.zhen.mypersonalshop.Model.Cart;
import com.zhen.mypersonalshop.Model.Product;
import com.zhen.mypersonalshop.Model.User;
import com.zhen.mypersonalshop.Repository.ProductRepository;
import com.zhen.mypersonalshop.Service.ProductService;
import com.zhen.mypersonalshop.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class CartTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Test
    public void testAddOneCartItem(){
        Optional<Product> product = productService.getProduct(1);
        Optional<User> user = userService.getUser(1);

        Cart cart = new Cart();
        cart.setUser(user.get());
        cart.setProduct(product.get());
    };

}
