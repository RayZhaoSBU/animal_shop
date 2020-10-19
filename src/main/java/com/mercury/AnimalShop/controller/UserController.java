package com.mercury.AnimalShop.controller;

import com.mercury.AnimalShop.bean.User;
import com.mercury.AnimalShop.http.Response;
import com.mercury.AnimalShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @PreAuthorize("permitAll()")
    @PostMapping
    public Response addUser(@RequestBody User user) {
        return userService.register(user);
    }

    @PutMapping
    public Response changeUser(@RequestBody User user, Authentication authentication) {
        return userService.changePassword(user, authentication);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public Response deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }
}
