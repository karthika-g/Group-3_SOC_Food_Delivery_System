package com.food.delivery.service;

import com.food.delivery.entity.Cart;
import com.food.delivery.model.request.AddToCartRequest;
import com.food.delivery.model.request.CartDTO;

/**
 * @author Z003YZ0D Akshay Sahu
 */
public interface CartService {
    CartDTO addToCart(AddToCartRequest addToCartRequest);

    CartDTO viewCart();

    CartDTO convertToDTO(Cart cart);
}
