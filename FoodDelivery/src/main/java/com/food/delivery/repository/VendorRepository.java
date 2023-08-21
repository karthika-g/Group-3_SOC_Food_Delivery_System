package com.food.delivery.repository;

import com.food.delivery.entity.Menu;
import com.food.delivery.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Z003YZ0D Akshay Sahu
 */
@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
    boolean existsByEmail(String email);

    @Override
    Optional<Vendor> findById(Long aLong);

    Optional<Vendor> findByEmail(String email);
}