package com.mercury.AnimalShop.controller;

import com.mercury.AnimalShop.bean.Product;
import com.mercury.AnimalShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public void save(@RequestBody Product product) {
        productService.save(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable long id) {
        return productService.getByProductId(id);
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }
}
