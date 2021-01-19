package com.mercury.AnimalShop.controller;

import java.util.List;

import com.mercury.AnimalShop.bean.Cart;
import com.mercury.AnimalShop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public void save(@RequestBody Cart cart){
        System.out.println("cart controller " + cart.toString());
        cartService.save(cart);
    }

    @PostMapping("/update")
    public void update(@RequestBody Cart cart){
        cartService.update(cart);
    }


    @GetMapping("/{id}")
    public List<Cart> getByUserId(@PathVariable long id){
        return  cartService.getByUserId(id);
    }

    @PutMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        cartService.deleteById(id);
    }
}
