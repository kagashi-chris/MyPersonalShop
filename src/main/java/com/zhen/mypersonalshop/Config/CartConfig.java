package com.zhen.mypersonalshop.Config;

import com.zhen.mypersonalshop.Model.Cart;
import com.zhen.mypersonalshop.Service.CartService;
import com.zhen.mypersonalshop.Service.CartServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
public class CartConfig {

    @Bean
    public CartService cartService(){
        return new CartServiceImpl();
    }

    @Bean
    public Cart cart(){
        return new Cart();
    }


}
