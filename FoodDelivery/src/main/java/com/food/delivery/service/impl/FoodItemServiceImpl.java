package com.food.delivery.service.impl;

import com.food.delivery.entity.*;
import com.food.delivery.model.request.FoodItemDTO;
import com.food.delivery.repository.FoodItemRepository;
import com.food.delivery.service.FoodItemService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Z003YZ0D Akshay Sahu
 */
@Service
@Slf4j
public class FoodItemServiceImpl implements FoodItemService {
    @Autowired
    private FoodItemRepository foodItemRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<FoodItemDTO> getAllFoodItems() {
        List<FoodItem> foodItems = foodItemRepository.findAll();
        return foodItems.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    @Override
    public FoodItemDTO convertToDTO(FoodItem foodItem) {
        return modelMapper.map(foodItem, FoodItemDTO.class);
    }
}


