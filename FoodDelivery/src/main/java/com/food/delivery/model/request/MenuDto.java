package com.food.delivery.model.request;

import com.food.delivery.entity.Vendor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Z003YZ0D Akshay Sahu
 */

@Builder
@Data
public class MenuDto {
    private String name;
    private String description;
    private Long vendorId;
}
