package com.food.delivery.model.request;

import lombok.Data;

/**
 * @author Z003YZ0D Akshay Sahu
 */
@Data
public class VendorDTO {
    private Long id;
    private String name;
    private String description;
    private String email;
    private String contactNumber;
    private String operatingHours;
    private String address;
    // Other fields, getters, setters

}


