package com.food.delivery.controller;
import com.food.delivery.model.request.*;
import com.food.delivery.service.CartService;
import com.food.delivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author Z003YZ0D Akshay Sahu
 */
@RestController
@RequestMapping("/api")
public class OrderingController {
    @Autowired
    private FoodItemService foodItemService;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/food-items")
    public ResponseEntity<List<FoodItemDTO>> getAllFoodItems() {
        List<FoodItemDTO> foodItems = foodItemService.getAllFoodItems();
        return ResponseEntity.ok(foodItems);
    }

    @PostMapping("/cart/add")
    public ResponseEntity<CartDTO> addToCart(@RequestBody AddToCartRequest addToCartRequest) {
        CartDTO updatedCart = cartService.addToCart(addToCartRequest);
        return ResponseEntity.ok(updatedCart);
    }

    @GetMapping("/cart")
    public ResponseEntity<CartDTO> viewCart() {
        CartDTO cart = cartService.viewCart();
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/orders")
    public ResponseEntity<OrderDTO> placeOrder(@RequestBody PlaceOrderRequest placeOrderRequest) {
        OrderDTO order = orderService.placeOrder(placeOrderRequest);
        return ResponseEntity.ok(order);
    }
}

