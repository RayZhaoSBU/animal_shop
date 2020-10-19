package com.mercury.AnimalShop.dao;

import com.mercury.AnimalShop.bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Long> {
    public List<Product> findByName(String name);
}
