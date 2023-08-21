package com.food.delivery.service;

/**
 * @author Z003YZ0D Akshay Sahu
 */
import com.food.delivery.entity.Vendor;
import com.food.delivery.model.request.LoginDto;

public interface AuthService {
    String login(LoginDto loginDto);

    Vendor getCurrentUser();
}