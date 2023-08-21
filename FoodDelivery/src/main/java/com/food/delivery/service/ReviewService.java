package com.food.delivery.service;

import com.food.delivery.entity.Menu;
import com.food.delivery.entity.Review;
import com.food.delivery.exception.ApplicationException;
import com.food.delivery.model.request.MenuDto;

import java.util.List;

/**
 * @author Z003YZ0D Akshay Sahu
 */
public interface ReviewService {

    Review createReview(Review dto) throws ApplicationException;

    List<Review> getReviewsByMenuId(Long menuId);
}
