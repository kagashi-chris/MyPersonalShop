package com.zhen.mypersonalshop.Config;

import com.zhen.mypersonalshop.Model.Product;
import com.zhen.mypersonalshop.Service.ProductService;
import com.zhen.mypersonalshop.Service.ProductServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
public class ProductConfig {

    @Bean
    public ProductService productService()
    {
        return new ProductServiceImpl();
    }

    @Bean
    public Product product(){
        return new Product();
    }


}
