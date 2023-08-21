package com.food.delivery.model.request;

import lombok.Data;

/**
 * @author Z003YZ0D Akshay Sahu
 */
@Data
public class OrderItemDTO {
    private Long itemId;
    private FoodItemDTO foodItem;
    private int quantity;
    // Other fields, getters, setters
}
