package com.food.delivery.constant;

/**
 * @author z003yz0d Akshay Sahu
 */

public class SecurityConstants {

    private SecurityConstants() {
    }
    public static final String[] PUBLIC_URLS = {"/actuator/health","/apis*","/swagger-ui/*","/apis/swagger-config*","/favicon.ico","/actuator/prometheus"};
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String TIMEZONE_UTC = "UTC";
    public static final String FORMAT = "dd-MM-yyyy HH:mm:SS";
    public static final int SEVEN = 7;
}
