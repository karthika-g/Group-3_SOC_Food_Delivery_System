package com.food.delivery.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
/**
 * @author Z003YZ0D Akshay Sahu
 */
@Entity
@Data
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double price;
    // Other fields, getters, setters
}
