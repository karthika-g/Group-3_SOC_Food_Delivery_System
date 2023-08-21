package com.food.delivery.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @author Z003YZ0D Akshay Sahu
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApplicationException extends Exception{
    /**
     * HttpStatus - status
     */
    private HttpStatus status;

    /**
     * String -message
     */
    private String message;
}
