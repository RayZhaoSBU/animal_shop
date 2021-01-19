package com.mercury.AnimalShop.dao;

import com.mercury.AnimalShop.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Long> {
    public User findByUsername(String name);
    public List<User> findByEmail(String email);
}
