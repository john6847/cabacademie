package com.login.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Collections;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api/login")
public class LoginController {

    @RequestMapping(method = POST,
            path = "",
            produces = APPLICATION_JSON_VALUE)
    public Map<String, Object> login(Authentication auth) {
        return Collections.singletonMap("user", auth.getName());
    }
}
