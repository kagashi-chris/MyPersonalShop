package com.zhen.mypersonalshop.Config;

import com.zhen.mypersonalshop.Model.User;
import com.zhen.mypersonalshop.Service.UserService;
import com.zhen.mypersonalshop.Service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.zhen.mypersonalshop.Repository")
public class UserConfig {

    @Bean
    public UserService userService(){
        return new UserServiceImpl();
    }

    @Bean
    public User user(){
        return new User();
    }
}
