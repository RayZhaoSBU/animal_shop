package com.mercury.AnimalShop.dao;

import com.mercury.AnimalShop.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    public User findByUsername(String name);
}
