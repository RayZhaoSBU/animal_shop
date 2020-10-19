package com.mercury.AnimalShop.controller;


import com.mercury.AnimalShop.bean.Feedback;
import com.mercury.AnimalShop.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public void save(@RequestBody Feedback feedback) {
        feedbackService.save(feedback);
    }

    @GetMapping
    public List<Feedback> getAll(){
        return feedbackService.getAll();
    }
}
