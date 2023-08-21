package com.food.delivery.service.impl;

import com.food.delivery.entity.Menu;
import com.food.delivery.entity.Vendor;
import com.food.delivery.exception.ApplicationException;
import com.food.delivery.model.request.MenuDto;
import com.food.delivery.repository.MenuRepository;
import com.food.delivery.repository.VendorRepository;
import com.food.delivery.service.MenuService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Z003YZ0D Akshay Sahu
 */
@Service
@Slf4j
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Menu createMenu(MenuDto menuDto) throws ApplicationException {
        Menu menu = modelMapper.map(menuDto, Menu.class);
        try {
            Optional<Vendor> optionalVendor = vendorRepository.findById(menuDto.getVendorId());
            if (!optionalVendor.isPresent()) {
                throw new EntityNotFoundException("Vendor ID does not exists");
            }
            menu.setVendor(optionalVendor.get());

            return menuRepository.save(menu);
        } catch (Exception e){
            log.error("exception in createMenu ");
            throw new ApplicationException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @Override
    public List<Menu> getMenusByVendorId(Long vendorId) {
        return menuRepository.findByVendorId(vendorId);
    }
}
