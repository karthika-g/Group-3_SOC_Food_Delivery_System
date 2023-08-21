package com.food.delivery.service;

import com.food.delivery.entity.FoodItem;
import com.food.delivery.model.request.FoodItemDTO;

import java.util.List;

/**
 * @author Z003YZ0D Akshay Sahu
 */
public interface FoodItemService {
    List<FoodItemDTO> getAllFoodItems();

    FoodItemDTO convertToDTO(FoodItem foodItem);
}
