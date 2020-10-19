package com.mercury.AnimalShop.dao;

import com.mercury.AnimalShop.bean.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDao extends JpaRepository<Order, Long> {
    public List<Order> findByUserId(long id);
}
