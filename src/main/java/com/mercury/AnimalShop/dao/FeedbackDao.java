package com.mercury.AnimalShop.dao;

import com.mercury.AnimalShop.bean.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackDao extends JpaRepository<Feedback, Long> {
}
