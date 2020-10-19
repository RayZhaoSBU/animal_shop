package com.mercury.AnimalShop.service;

import com.mercury.AnimalShop.dao.UserDao;
import com.mercury.AnimalShop.http.AuthenticationSuccessResponse;
import com.mercury.AnimalShop.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserDao userDao;

    public Response checkLogin(Authentication authentication) {
        if (authentication != null) {
            Response response = new AuthenticationSuccessResponse(true, 200, "Logged In!", userDao.findByUsername(authentication.getName()));
            return response;
        } else {
            return new Response(false);
        }
    }
}
