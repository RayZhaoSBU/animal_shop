package com.mercury.AnimalShop.controller;

import com.mercury.AnimalShop.bean.UserInfo;
import com.mercury.AnimalShop.http.Response;
import com.mercury.AnimalShop.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-details")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @GetMapping("/{userId}")
    public UserInfo getUserDetail(@PathVariable long userId) {
        return userInfoService.getByUserId(userId);
    }

    @PostMapping
    public Response postUserDetails(@RequestBody UserInfo userInfo, Authentication authentication) {
        return userInfoService.addUserInfo(userInfo, authentication);
    }

    @PutMapping
    public Response putUserInfos(@RequestBody UserInfo userInfo) {
        return userInfoService.updateUserInfo(userInfo);
    }

}
