package com.food.delivery.repository;

/**
 * @author Z003YZ0D Akshay Sahu
 */
import com.food.delivery.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
    // You can add custom query methods here if needed
}
