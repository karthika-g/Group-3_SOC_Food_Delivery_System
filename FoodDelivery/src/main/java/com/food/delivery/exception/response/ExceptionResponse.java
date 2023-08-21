package com.food.delivery.exception.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Model to be used as a default
 * for exceptions thrown inside
 * the application.
 *
 * @author z004eu6b
 */
@Data
@AllArgsConstructor
public class ExceptionResponse {

    private int status;
    private String message;
    private String url;
}
