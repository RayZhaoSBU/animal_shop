package com.mercury.AnimalShop.controller;

import com.mercury.AnimalShop.http.Response;
import com.mercury.AnimalShop.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/checklogin")
    public Response checkLogin(Authentication authentication) {
        return authService.checkLogin(authentication);
    }
}
