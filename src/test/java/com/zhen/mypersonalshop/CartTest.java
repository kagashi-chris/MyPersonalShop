package com.zhen.mypersonalshop;

import com.zhen.mypersonalshop.Model.Cart;
import com.zhen.mypersonalshop.Model.Product;
import com.zhen.mypersonalshop.Model.User;
import com.zhen.mypersonalshop.Repository.CartRepository;
import com.zhen.mypersonalshop.Repository.ProductRepository;
import com.zhen.mypersonalshop.Service.CartService;
import com.zhen.mypersonalshop.Service.ProductService;
import com.zhen.mypersonalshop.Service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.relational.core.sql.TrueCondition;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CartTest {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private CartRepository cartRepository;

    @Test
    public void testAddOneCartItem(){

    };

}
