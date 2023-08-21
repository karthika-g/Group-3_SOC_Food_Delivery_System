package com.food.delivery.service.impl;

import com.food.delivery.entity.*;
import com.food.delivery.model.request.*;
import com.food.delivery.repository.CartRepository;
import com.food.delivery.repository.FoodItemRepository;
import com.food.delivery.service.AuthService;
import com.food.delivery.service.CartService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Z003YZ0D Akshay Sahu
 */
@Slf4j
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private AuthService authService;

    @Autowired
    private FoodItemRepository foodItemRepository;



    public CartDTO addToCart(AddToCartRequest addToCartRequest) {
        Cart cart = getOrCreateCart(); // Implement logic to get or create cart
        FoodItem foodItem = foodItemRepository.findById(addToCartRequest.getItemId())
                .orElseThrow(() -> new EntityNotFoundException("Food item not found with id: " + addToCartRequest.getItemId()));

        CartItem cartItem = new CartItem();
        cartItem.setFoodItem(foodItem);
        cartItem.setQuantity(addToCartRequest.getQuantity());

        cart.getCartItems().add(cartItem);
        cart = cartRepository.save(cart);

        return convertToDTO(cart);
    }

    public CartDTO viewCart() {
        Cart cart = getOrCreateCart(); // Implement logic to get or create cart
        return convertToDTO(cart);
    }

    private Cart getOrCreateCart() {
        Vendor currentUser = authService.getCurrentUser(); // Implement logic to get the current authenticated user

        Cart cart = cartRepository.findByUser(currentUser);

        if (cart == null) {
            cart = new Cart();
            cart.setUser(currentUser);
            cart = cartRepository.save(cart);
        }

        return cart;
    }



    public CartDTO convertToDTO(Cart cart) {
        CartDTO dto = new CartDTO();
        dto.setId(cart.getId());
        List<CartItemDTO> cartItemDTOs = cart.getCartItems().stream()
                .map(this::convertToCartItemDTO)
                .collect(Collectors.toList());
        dto.setCartItems(cartItemDTOs);
        return dto;
    }

    private CartItemDTO convertToCartItemDTO(CartItem cartItem) {
        CartItemDTO dto = new CartItemDTO();
        dto.setId(cartItem.getId());
        dto.setFoodItem(convertToFoodItemDTO(cartItem.getFoodItem()));
        dto.setQuantity(cartItem.getQuantity());
        return dto;
    }

    private FoodItemDTO convertToFoodItemDTO(FoodItem foodItem) {
        FoodItemDTO dto = new FoodItemDTO();
        dto.setId(foodItem.getId());
        dto.setName(foodItem.getName());
        dto.setDescription(foodItem.getDescription());
        dto.setPrice(foodItem.getPrice());
        return dto;
    }
}

