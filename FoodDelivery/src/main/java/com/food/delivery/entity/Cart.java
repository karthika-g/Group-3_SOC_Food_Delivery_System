package com.food.delivery.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Z003YZ0D Akshay Sahu
 */
@Entity
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vendor user;

    @JsonManagedReference
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<CartItem> cartItems = new ArrayList<>();
    // Other fields, getters, setters
}

