package com.login.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
@RequestMapping(value = "/api/login")
public class LoginController {

    @RequestMapping("/user")
    public Principal user(HttpServletRequest request,  Principal user) {
       //String userName= request.getSession().getAttribute("username").toString();

//        System.out.println(user.getName());
        return user;
    }
}
