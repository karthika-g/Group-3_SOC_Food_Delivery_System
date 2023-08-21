package com.food.delivery.model.request;

import lombok.Data;

/**
 * @author Z003YZ0D Akshay Sahu
 */
@Data
public class CartItemDTO {
    private Long id;
    private MenuDto foodItem;
    private int quantity;
    // Other fields, getters, setters
}

