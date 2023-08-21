package com.food.delivery.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * @author Z003YZ0D Akshay Sahu
 */
@Data
@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String description;
    // Add more menu fields
    private double price;

    @JsonBackReference
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "vendor_id", nullable = false)
    private Vendor vendor;

    @JsonManagedReference
    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Review> reviews;

    // Getters and setters
}

