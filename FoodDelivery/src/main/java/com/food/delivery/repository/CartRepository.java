package com.food.delivery.repository;

/**
 * @author Z003YZ0D Akshay Sahu
 */
import com.food.delivery.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUser(Vendor user);
}
