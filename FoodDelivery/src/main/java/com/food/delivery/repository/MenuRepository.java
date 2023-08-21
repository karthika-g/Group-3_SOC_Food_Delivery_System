package com.food.delivery.repository;

/**
 * @author Z003YZ0D Akshay Sahu
 */

import com.food.delivery.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findByVendorId(Long vendorId);
    // You can add custom query methods here if needed
}




