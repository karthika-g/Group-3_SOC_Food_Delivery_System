package com.food.delivery.service;

import com.food.delivery.entity.Vendor;
import com.food.delivery.model.request.VendorDTO;
import com.food.delivery.model.request.VendorRegistrationRequest;

/**
 * @author Z003YZ0D Akshay Sahu
 */
public interface VendorService {

    VendorDTO registerVendor(VendorRegistrationRequest vendor);

    Vendor getVendorById(Long id);

    Vendor updateVendor(Vendor request);

    String deleteVendor(Vendor request);
}
