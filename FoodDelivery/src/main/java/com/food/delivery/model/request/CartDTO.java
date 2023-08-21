package com.food.delivery.model.request;

import lombok.Data;

import java.util.List;

/**
 * @author Z003YZ0D Akshay Sahu
 */
@Data
public class CartDTO {
    private Long id;
    private List<CartItemDTO> cartItems;
    // Other fields, getters, setters
}

