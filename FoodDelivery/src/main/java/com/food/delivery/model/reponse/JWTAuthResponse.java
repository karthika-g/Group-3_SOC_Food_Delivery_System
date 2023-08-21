package com.food.delivery.model.reponse;

import lombok.Data;

/**
 * @author Z003YZ0D Akshay Sahu
 */

@Data
public class JWTAuthResponse {
    private String accessToken;
    private String tokenType;
}
