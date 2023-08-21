package com.food.delivery.repository;

/**
 * @author Z003YZ0D Akshay Sahu
 */

import com.food.delivery.entity.Menu;
import com.food.delivery.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByMenuId(Long menuId);
    // You can add custom query methods here if needed
}




