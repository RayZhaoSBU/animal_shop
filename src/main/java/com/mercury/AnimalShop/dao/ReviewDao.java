package com.mercury.AnimalShop.dao;

import com.mercury.AnimalShop.bean.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewDao extends JpaRepository<Review, Long> {
    public List<Review> findByProductId(long id);
}
