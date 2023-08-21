package com.food.delivery.controller;

import com.food.delivery.model.reponse.JWTAuthResponse;
import com.food.delivery.model.request.LoginDto;
import com.food.delivery.model.request.VendorDTO;
import com.food.delivery.model.request.VendorRegistrationRequest;
import com.food.delivery.service.AuthService;
import com.food.delivery.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Z003YZ0D Akshay Sahu
 */
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;
    private VendorService vendorService;

    // Build Login REST API
    @PostMapping("/login")
    public ResponseEntity<JWTAuthResponse> authenticate(@RequestBody LoginDto loginDto){
        String token = authService.login(loginDto);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<VendorDTO> registerVendor(@RequestBody VendorRegistrationRequest request) {
        VendorDTO vendorDTO = vendorService.registerVendor(request);
        return ResponseEntity.ok(vendorDTO);
    }
}
