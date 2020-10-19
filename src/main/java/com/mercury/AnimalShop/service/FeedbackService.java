package com.mercury.AnimalShop.service;

import com.mercury.AnimalShop.bean.Feedback;
import com.mercury.AnimalShop.dao.FeedbackDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    FeedbackDao feedbackDao;

    public void save(Feedback feedback) {
        feedbackDao.save(feedback);
    }

    public Feedback getById(long id) {
        return feedbackDao.findById(id).get();
    }

    public List<Feedback> getAll() {
        return feedbackDao.findAll();
    }
}
