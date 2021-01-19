package com.mercury.AnimalShop.service;

import java.util.List;

import com.mercury.AnimalShop.bean.Review;
import com.mercury.AnimalShop.dao.ReviewDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReviewService {


    @Autowired
    private ReviewDao rd;

    public void save(Review review) {
        rd.save(review);
    }

    public List<Review> getByProductId(long id){
        return rd.findByProductId(id);
    }

    public Review getById(long id) {
        return rd.findById(id).get();
    }

    public List<Review> getAll(){
        return rd.findAll();
    }
}
