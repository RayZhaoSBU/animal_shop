package com.mercury.AnimalShop.dao;

import com.mercury.AnimalShop.bean.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewDao extends JpaRepository<Review, Long> {
}
