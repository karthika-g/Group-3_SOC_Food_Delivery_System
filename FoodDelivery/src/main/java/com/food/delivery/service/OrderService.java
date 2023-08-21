package com.food.delivery.service;

import com.food.delivery.model.request.OrderDTO;
import com.food.delivery.model.request.PlaceOrderRequest;

/**
 * @author Z003YZ0D Akshay Sahu
 */
public interface OrderService {
    OrderDTO placeOrder(PlaceOrderRequest placeOrderRequest);
}
