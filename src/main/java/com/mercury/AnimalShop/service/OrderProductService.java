package com.mercury.AnimalShop.service;

import com.mercury.AnimalShop.bean.OrderProduct;
import com.mercury.AnimalShop.dao.OrderProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductService {

    @Autowired
    private OrderProductDao orderProductDao;

    public void save(OrderProduct orderProduct) {
        orderProductDao.save(orderProduct);
    }

    public void deleteById(long id) {
        orderProductDao.deleteById(id);
    }

    public List<OrderProduct> getByUserId(long id) {
        return orderProductDao.findByUserId(id);
    }
}
