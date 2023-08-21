package com.food.delivery.model.request;

import lombok.Data;

/**
 * @author Z003YZ0D Akshay Sahu
 */
@Data
public class AddToCartRequest {
    private Long itemId;
    private int quantity;
    // Other fields, getters, setters
}
