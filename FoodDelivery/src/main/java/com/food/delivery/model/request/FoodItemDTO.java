package com.food.delivery.model.request;

/**
 * @author Z003YZ0D Akshay Sahu
 */

import lombok.Data;

@Data
public class FoodItemDTO {
    private Long id;
    private String name;
    private String description;
    private double price;
    // Other fields, getters, setters
}

