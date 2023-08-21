package com.food.delivery.model.request;

/**
 * @author Z003YZ0D Akshay Sahu
 */

import lombok.Data;

@Data
public class VendorRegistrationRequest {
    private String name;
    private String description;
    private String email;
    private String password;
    private String contactNumber;
    private String operatingHours;
    private String address;
    // Other fields, getters, setters

}

