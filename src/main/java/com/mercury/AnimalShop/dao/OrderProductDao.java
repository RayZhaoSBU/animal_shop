package com.mercury.AnimalShop.dao;

import com.mercury.AnimalShop.bean.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderProductDao extends JpaRepository<OrderProduct, Long> {
    public List<OrderProduct> findByUserId(long id);
}
