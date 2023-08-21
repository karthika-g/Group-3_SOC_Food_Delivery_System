package com.food.delivery.service.impl;

import com.food.delivery.entity.Menu;
import com.food.delivery.entity.Review;
import com.food.delivery.exception.ApplicationException;
import com.food.delivery.repository.MenuRepository;
import com.food.delivery.repository.ReviewRepository;
import com.food.delivery.service.ReviewService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Z003YZ0D Akshay Sahu
 */
@Service
@Slf4j
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Review createReview(Review dto) throws ApplicationException {

        try {
            Optional<Menu> optionalMenu = menuRepository.findById(dto.getMenu().getId());
            if (!optionalMenu.isPresent()) {
                throw new EntityNotFoundException("Vendor ID does not exists");
            }
            Review review = new Review();
            review.setReview(dto.getReview());
            review.setRating(dto.getRating());
            review.setMenu(optionalMenu.get());
                return reviewRepository.save(review);
        } catch (Exception e){
            log.error("exception in createReview ");
            throw new ApplicationException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @Override
    public List<Review> getReviewsByMenuId(Long menuId) {
        return reviewRepository.findByMenuId(menuId);
    }


}
