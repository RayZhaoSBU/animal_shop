package com.mercury.AnimalShop.controller;

import com.mercury.AnimalShop.bean.Email;
import com.mercury.AnimalShop.bean.User;
import com.mercury.AnimalShop.dao.UserDao;
import com.mercury.AnimalShop.http.Response;
import com.mercury.AnimalShop.service.EmailService;
import com.mercury.AnimalShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sendMail")
public class EmailController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EmailService emailService;

    @Autowired
    private UserService userService;

    @PostMapping
    public Response sendEmail1(@RequestBody List<String> addressList) {
        Email email_email = new Email();
        String newPassword=Integer.toString((int) Math.floor(Math.random()*101533)) ;
        System.out.println("new pass word is "+newPassword);
        email_email.setToAddress(addressList);
        List<User> users=userService.getAllByEmail(addressList.get(0));
        for(User user:users) {
            user.setPassword(passwordEncoder.encode(newPassword));
            userDao.save(user);
        }
        email_email.setSubject("PASSWORD RECOVERY");
        email_email.setContent("This email is from animal shop. Your new Password is "
                                + newPassword +
                                ". Please change your password after sign in immediately.");
        emailService.sendMail(email_email);

        return new Response(true);
    }

    @PostMapping("/shipped")
    public Response sendEmail2(@RequestBody List<String> addressList) {
        Email email_email = new Email();
        email_email.setToAddress(addressList);
        email_email.setSubject("Animal Shop");
        email_email.setContent("Your recent order has been shipped. Please log in to check status");
        emailService.sendMail(email_email);
        return new Response(true);
    }
}
