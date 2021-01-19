package com.mercury.AnimalShop.dao;

import java.util.List;

import com.mercury.AnimalShop.bean.Cart;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartDao extends JpaRepository<Cart, Long> {
    public List<Cart> findByUserId(long id);
}
