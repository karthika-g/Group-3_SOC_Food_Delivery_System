package com.food.delivery.controller;

import com.food.delivery.entity.Menu;
import com.food.delivery.entity.Review;
import com.food.delivery.exception.ApplicationException;
import com.food.delivery.model.request.MenuDto;
import com.food.delivery.service.MenuService;
import com.food.delivery.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) throws ApplicationException {
        Review createdReview = reviewService.createReview(review);
        return ResponseEntity.ok(createdReview);
    }


    @GetMapping("/menu/{menuId}")
    public ResponseEntity<List<Review>> getMenusByVendor(@PathVariable Long menuId) {
        List<Review> menus = reviewService.getReviewsByMenuId(menuId);
        return ResponseEntity.ok(menus);
    }

    // Add more menu-related endpoints
}

