package com.mercury.AnimalShop.dao;

import com.mercury.AnimalShop.bean.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingDao extends JpaRepository<Shipping, Long> {
}
