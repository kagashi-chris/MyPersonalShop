package com.zhen.mypersonalshop.Config;

import com.zhen.mypersonalshop.Model.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableJpaRepositories
public class RoleConfig {

    @Bean
    public Role role(){
        return new Role();
    }
}
