package com.food.delivery.security;

/**
 * @author Z003YZ0D Akshay Sahu
 */
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.food.delivery.model.reponse.ExceptionResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.ErrorResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private JwtTokenProvider jwtTokenProvider;

    private UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider, UserDetailsService userDetailsService) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            // get JWT token from http request
            String token = getTokenFromRequest(request);

            // validate token
            if (StringUtils.hasText(token) && jwtTokenProvider.validateToken(token)) {

                // get username from token
                String username = jwtTokenProvider.getUsername(token);

                // load the user associated with token
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );

                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            }

            filterChain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Exception occured in AuthTokenFilter{}", e.getMessage());
            ExceptionResponse errorResponse = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(), request.getRequestURI());
            errorResponse.setMessage(e.getMessage());
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            try {
                response.getWriter().write(convertObjectToJson(errorResponse));
            } catch (JsonProcessingException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

        public String convertObjectToJson(Object object) throws JsonProcessingException {
            if (object == null) {
                return null;
            }
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(object);
        }

    private String getTokenFromRequest(HttpServletRequest request){

        String bearerToken = request.getHeader("Authorization");

        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7, bearerToken.length());
        }

        return null;
    }
}
