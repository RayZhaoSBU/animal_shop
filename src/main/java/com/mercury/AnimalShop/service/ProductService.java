package com.mercury.AnimalShop.service;

import org.springframework.stereotype.Service;
import com.mercury.AnimalShop.bean.Product;
import com.mercury.AnimalShop.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public void save(Product product) {
        productDao.save(product);
    }

    public Product getByProductId(long id) {
        return productDao.findById(id).get();
    }

    public List<Product> getByName(String name) {
        return productDao.findByName(name);
    }

    public List<Product> getAll() {
        return productDao.findAll();
    }
}
