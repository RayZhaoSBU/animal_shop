package com.mercury.AnimalShop.controller;

import com.mercury.AnimalShop.bean.Order;
import com.mercury.AnimalShop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public void save(@RequestBody Order order) {
        orderService.save(order);
    }

    @GetMapping("/{id}")
    public List<Order> getOrdersByUserId(@PathVariable long id){
        return orderService.getByUserId(id);
    }

    @GetMapping
    public List<Order> getAll(){
        return orderService.getAll();
    }
}
