package com.zhen.mypersonalshop.Config;

import com.zhen.mypersonalshop.Model.Role;
import com.zhen.mypersonalshop.Model.UserRole;
import com.zhen.mypersonalshop.Service.UserRoleService;
import com.zhen.mypersonalshop.Service.UserRoleServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
public class UserRoleConfig {

    @Bean
    public UserRole userRole()
    {
        return new UserRole();
    }

    @Bean
    public UserRoleService userRoleService()
    {
        return new UserRoleServiceImpl();
    }
}
