package com.zhen.mypersonalshop.Controller;

import com.zhen.mypersonalshop.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;
}
