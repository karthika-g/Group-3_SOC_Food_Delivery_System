package com.food.delivery.controller;

import com.food.delivery.entity.Vendor;
import com.food.delivery.model.request.VendorDTO;
import com.food.delivery.model.request.VendorRegistrationRequest;
import com.food.delivery.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Z003YZ0D Akshay Sahu
 */
@RestController
@RequestMapping("/api/vendors")
public class VendorController {
    @Autowired
    private VendorService vendorService;



    @GetMapping("/{id}")
    public ResponseEntity<Vendor> getVendor(@PathVariable Long id) {
        Vendor vendor = vendorService.getVendorById(id);
        return ResponseEntity.ok(vendor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vendor> updateVendor(@PathVariable Vendor request) {
        Vendor vendor = vendorService.updateVendor(request);
        return ResponseEntity.ok(vendor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVendor(@PathVariable Vendor request) {
        return ResponseEntity.ok(vendorService.deleteVendor(request));
    }

}

