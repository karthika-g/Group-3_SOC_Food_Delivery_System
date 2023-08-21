package com.food.delivery.service.impl;

import com.food.delivery.entity.Vendor;
import com.food.delivery.model.request.VendorDTO;
import com.food.delivery.model.request.VendorRegistrationRequest;
import com.food.delivery.repository.VendorRepository;
import com.food.delivery.service.VendorService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Z003YZ0D Akshay Sahu
 */
@Service
public class VendorServiceImpl implements VendorService {
    @Autowired
    private VendorRepository vendorRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder; // Assuming you've configured a password encoder bean


    @Override
    public VendorDTO registerVendor(VendorRegistrationRequest registrationRequest) {
        // Check if a vendor with the provided email already exists
        if (vendorRepository.existsByEmail(registrationRequest.getEmail())) {
            throw new IllegalArgumentException("Vendor with this email already exists");
        }
        Vendor vendor = modelMapper.map(registrationRequest, Vendor.class);

        // Hash the password before storing
        String hashedPassword = passwordEncoder.encode(registrationRequest.getPassword());
        vendor.setPassword(hashedPassword);

        return modelMapper.map(vendorRepository.save(vendor), VendorDTO.class);
    }

    @Override
    public Vendor getVendorById(Long id) {
        return vendorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vendor not found with id: " + id));
    }

    // Add more vendor-related methods
}