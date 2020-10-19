package com.mercury.AnimalShop.service;

import com.mercury.AnimalShop.bean.Shipping;
import com.mercury.AnimalShop.dao.ShippingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingService {

    @Autowired
    private ShippingDao shippingDao;

    public void save(Shipping shipping) {
        shippingDao.save(shipping);
    }

    public Shipping getByShippingId (long id) {
        return shippingDao.findById(id).get();
    }

    public List<Shipping> getAll() {
        return shippingDao.findAll();
    }
}
