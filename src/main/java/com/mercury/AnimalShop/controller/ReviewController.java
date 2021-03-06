package com.mercury.AnimalShop.controller;

import java.util.List;

import com.mercury.AnimalShop.bean.Review;
import com.mercury.AnimalShop.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewController {


    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public void save(@RequestBody Review review){
        reviewService.save(review);
    }

    @GetMapping("/{id}")
    public List<Review> getByProductId(@PathVariable long id){
        return reviewService.getByProductId(id);
    }

    @GetMapping
    public List<Review> getAll(){
        return reviewService.getAll();
    }
}
