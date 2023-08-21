package com.food.delivery.model.request;

import lombok.Data;

/**
 * @author Z003YZ0D Akshay Sahu
 */
@Data
public class OrderItemRequest {
    private Long itemId;
    private int quantity;
}

