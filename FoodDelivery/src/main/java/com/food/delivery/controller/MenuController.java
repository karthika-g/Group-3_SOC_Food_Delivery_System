package com.food.delivery.controller;

import com.food.delivery.entity.Menu;
import com.food.delivery.exception.ApplicationException;
import com.food.delivery.model.request.MenuDto;
import com.food.delivery.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @PostMapping
    public ResponseEntity<Menu> createMenu(@RequestBody MenuDto menu) throws ApplicationException {
        Menu createdMenu = menuService.createMenu(menu);
        return ResponseEntity.ok(createdMenu);
    }

    @GetMapping("/vendor/{vendorId}")
    public ResponseEntity<List<Menu>> getMenusByVendor(@PathVariable Long vendorId) {
        List<Menu> menus = menuService.getMenusByVendorId(vendorId);
        return ResponseEntity.ok(menus);
    }

    // Add more menu-related endpoints
}

