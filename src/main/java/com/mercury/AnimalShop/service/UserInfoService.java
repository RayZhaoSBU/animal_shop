package com.mercury.AnimalShop.service;

import com.mercury.AnimalShop.bean.User;
import com.mercury.AnimalShop.bean.UserInfo;
import com.mercury.AnimalShop.dao.UserDao;
import com.mercury.AnimalShop.dao.UserInfoDao;
import com.mercury.AnimalShop.http.Response;
import com.mercury.AnimalShop.http.UserInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Autowired
    UserDao userDao;

    @Autowired
    UserInfoDao userInfoDao;

    public UserInfo getByUserId (long id) {
        return userInfoDao.findByUserId(id);
    }

    public Response addUserInfo (UserInfo userInfo, Authentication authentication) {
        User user = userDao.findByUsername(authentication.getName());
        userInfo.setUser(user);
        return new UserInfoResponse(true, userInfoDao.save(userInfo));
    }

    public Response updateUserInfo(UserInfo userInfo) {
        UserInfo currentInfo = userInfoDao.findById(userInfo.getId()).get();
        userInfo.setUser(currentInfo.getUser());
        currentInfo = userInfo;
        userInfoDao.save(currentInfo);
        return new Response(true);
    }
}
