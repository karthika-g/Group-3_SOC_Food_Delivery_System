package com.food.delivery.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
/**
 * @author Z003YZ0D Akshay Sahu
 */
@Entity
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference
    private FoodItem foodItem;

    @ManyToOne
    @JsonBackReference
    private Cart cart;

    private int quantity;
    // Other fields, getters, setters
}

