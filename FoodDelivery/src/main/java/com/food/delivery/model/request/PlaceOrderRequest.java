package com.food.delivery.model.request;

/**
 * @author Z003YZ0D Akshay Sahu
 */

import lombok.Data;

import java.util.List;

@Data
public class PlaceOrderRequest {
    private List<OrderItemRequest> items;
    private Long userId;
    private double totalPrice;
    // Other fields, getters, setters
}


