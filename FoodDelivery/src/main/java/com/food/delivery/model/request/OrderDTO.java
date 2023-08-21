package com.food.delivery.model.request;

import lombok.Data;

import java.util.List;

/**
 * @author Z003YZ0D Akshay Sahu
 */
@Data
public class OrderDTO {
    private Long id;
    private List<OrderItemDTO> orderItems;
    private double totalPrice;
    // Other fields, getters, setters
}
