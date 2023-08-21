package com.food.delivery.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.food.delivery.constant.ExceptionMessageConstants;
import com.food.delivery.model.reponse.ExceptionResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

/**
 * This class is custom
 * AccessDeniedHandler for providing
 * custom response in case
 * that exception is thrown from the
 * security context
 *
 * @author z003yz0d Akshay Sahu
 */

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    /**
     * Handler of
     * AccessDeniedException thrown
     * from security
     *
     * @param request               - that resulted in an <code>AccessDeniedException</code>
     * @param response              - so that the user agent can be advised of the failure
     * @param accessDeniedException - that caused the invocation
     * @throws IOException - IOException
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        ExceptionResponse exceptionResponse = new ExceptionResponse(UNAUTHORIZED.value(), ExceptionMessageConstants.INVALID_OR_MISSING_TOKEN,  request.getServletPath());
        OutputStream out = response.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.writeValue(out, exceptionResponse);
        out.flush();
    }
}