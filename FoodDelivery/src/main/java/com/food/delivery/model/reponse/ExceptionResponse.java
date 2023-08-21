package com.food.delivery.model.reponse;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Model to be used as a default
 * for exceptions thrown inside
 * the application.
 *
 * @author z003yz0d Akshay Sahu
 */
@Data
@AllArgsConstructor
public class ExceptionResponse {

    private int status;
    private String message;
    private String url;
}
