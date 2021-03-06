package com.mercury.AnimalShop.service;

import com.mercury.AnimalShop.bean.Profile;
import com.mercury.AnimalShop.bean.User;
import com.mercury.AnimalShop.bean.UserInfo;
import com.mercury.AnimalShop.dao.UserDao;
import com.mercury.AnimalShop.dao.UserInfoDao;
import com.mercury.AnimalShop.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAll() {
        return userDao.findAll();
    }

    public List<User> getAllByEmail(String email){
        return userDao.findByEmail(email);
    }

    public Response register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        List<Profile> profiles = new ArrayList<Profile>();
        profiles.add(new Profile(2));
        user.setProfiles(profiles);
        userDao.save(user);
        UserInfo newUserInfo=new UserInfo(" "," "," "," "," "," "," "," "," ",user);
        userInfoDao.save(newUserInfo);
        return new Response(true);
    }

    public Response registerAdmin(User user) {
//        System.out.println("register admin");
//        System.out.println(user.toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        List<Profile> profiles = new ArrayList<Profile>();
        profiles.add(new Profile(1));
        user.setProfiles(profiles);
        userDao.save(user);
        UserInfo newUserInfo=new UserInfo(" "," "," "," "," "," "," "," "," ",user);
        userInfoDao.save(newUserInfo);
        return new Response(true);
    }

    public Response changePassword(User user, Authentication authentication) {
        if(user.getUsername().equals(authentication.getName()) || isAdmin(authentication.getAuthorities())) {
            User u = userDao.findByUsername(user.getUsername());
            u.setPassword(passwordEncoder.encode(user.getPassword()));
            userDao.save(u);
        }else {
            return new Response(false);
        }
        return new Response(true);
    }

    public boolean isAdmin(Collection<? extends GrantedAuthority> profiles) {
        boolean isAdmin = false;
        for(GrantedAuthority profle: profiles) {
            if(profle.getAuthority().equals("ROLE_ADMIN")) {
                isAdmin = true;
            }
        };
        return isAdmin;
    }

    public Response deleteUser(long id) {
        if(userDao.findById(id).get() != null) {
            userDao.deleteById(id);
            return new Response(true);
        }else {
            return new Response(false, "User is not found!");
        }
    }
}
