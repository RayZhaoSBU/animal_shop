package com.mercury.AnimalShop.service;

import com.mercury.AnimalShop.bean.Category;
import com.mercury.AnimalShop.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryDao categoryDao;

    public void save(Category category) {
        categoryDao.save(category);
    }

    public List<Category> getAll() {
        return categoryDao.findAll();
    }
}
