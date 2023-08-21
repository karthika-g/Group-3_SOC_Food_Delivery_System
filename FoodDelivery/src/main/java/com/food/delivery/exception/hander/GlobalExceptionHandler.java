package com.food.delivery.exception.hander;


import com.food.delivery.exception.ApplicationException;
import com.food.delivery.exception.response.ExceptionResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


/**
 * Global Exception Handler class to handle all exception
 * thrown inside the application and provide
 * custom response to the client.
 *
 * @author z004eu6b
 */
@ControllerAdvice

/** The Constant log. */
public class GlobalExceptionHandler
{

    /**
     * handler for GenericException.
     *
     * @param exception - GenericException
     * @param request - HttpServletRequest
     * @return - ResponseEntity<ExceptionResponse>
     */
    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ExceptionResponse> sendResponse(ApplicationException exception, HttpServletRequest request)
    {
        exception.printStackTrace();
        ExceptionResponse response = new ExceptionResponse(exception.getStatus().value(), exception.getMessage(),
                request.getServletPath());
        return ResponseEntity.status(exception.getStatus()).body(response);
    }


}
