package com.mercury.AnimalShop.controller;

import com.mercury.AnimalShop.bean.Shipping;
import com.mercury.AnimalShop.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shippings")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @PostMapping
    public void save(@RequestBody Shipping shipping) {
        shippingService.save(shipping);
    }

    @GetMapping
    public List<Shipping> getAll(){
        return shippingService.getAll();
    }
}
