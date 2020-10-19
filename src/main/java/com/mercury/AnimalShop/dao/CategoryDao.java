package com.mercury.AnimalShop.dao;

import com.mercury.AnimalShop.bean.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Long> {

}
