package com.login.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "/api/login")
public class LoginController {

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}
