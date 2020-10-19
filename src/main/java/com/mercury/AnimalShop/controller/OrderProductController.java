package com.mercury.AnimalShop.controller;

import com.mercury.AnimalShop.bean.OrderProduct;
import com.mercury.AnimalShop.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderProducts")
public class OrderProductController {

    @Autowired
    private OrderProductService orderProductService;

    @PostMapping
    public void save(@RequestBody OrderProduct orderProduct){
        orderProductService.save(orderProduct);
    }

    @GetMapping("/{id}")
    public List<OrderProduct> getByUserId(@PathVariable long id){
        return  orderProductService.getByUserId(id);
    }

    @PutMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        orderProductService.deleteById(id);
    }
}
