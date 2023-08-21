package com.food.delivery.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Z003YZ0D Akshay Sahu
 */
@Data
@Entity
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    @Column(unique = true, nullable = false)
    private String email;
    private String password; // Store the hashed password
    private String contactNumber;
    private String operatingHours;
    private String address;

    @JsonManagedReference
    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Menu> menus = new ArrayList<>();

    // Getters and setters
}

