package com.mercury.AnimalShop.service;

import com.mercury.AnimalShop.bean.Order;
import com.mercury.AnimalShop.bean.OrderProduct;
import com.mercury.AnimalShop.bean.Product;
import com.mercury.AnimalShop.dao.OrderDao;
import com.mercury.AnimalShop.dao.OrderProductDao;
import com.mercury.AnimalShop.dao.ProductDao;
import com.mercury.AnimalShop.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private OrderProductDao orderProductDao;

    public List<Order> getByUserId(long id) {
        return orderDao.findByUserId(id);
    }

    public List<Order> getAll() {
        return orderDao.findAll();
    }

//    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Response save (Order order) {
        try {
            List<OrderProduct> purchases = order.getPurchases();
            order.setDate(new Date());
            purchases.forEach(orderProduct -> {
                Product product = (Product) productDao.findById(orderProduct.getProduct().getId()).get();
                orderProduct.setProduct(product);
                orderProduct.setOrder(order);
            });
            orderDao.save(order);
            return new Response(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false);
        }
    }

    public Response edit (Order order) {
        try{
            Order currentOrder = (Order) orderDao.findById(order.getId()).get();
            List<OrderProduct> purchasesToRemove = currentOrder.getPurchases();
            List<OrderProduct> purchases = order.getPurchases();
            purchases.forEach(orderProduct -> {
                Product product = (Product)productDao.findById(orderProduct.getId()).get();
                orderProduct.setProduct(product);
                orderProduct.setOrder(currentOrder);
            });

            if (purchases.size() > 0){
                purchasesToRemove = purchasesToRemove.stream().filter(orderProduct -> {
                    return !purchases.contains(orderProduct);
                }).collect(Collectors.toList());
            }
            currentOrder.setPurchases(purchases);
            orderDao.save(currentOrder);
            orderProductDao.deleteAll(purchasesToRemove);
            return new Response(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false);
        }
    }
}

