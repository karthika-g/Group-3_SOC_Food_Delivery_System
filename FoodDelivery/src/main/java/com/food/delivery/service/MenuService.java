package com.food.delivery.service;

import com.food.delivery.entity.Menu;
import com.food.delivery.exception.ApplicationException;
import com.food.delivery.model.request.MenuDto;

import java.util.List;

/**
 * @author Z003YZ0D Akshay Sahu
 */
public interface MenuService {
    Menu createMenu(MenuDto menu) throws ApplicationException;

    List<Menu> getMenusByVendorId(Long vendorId);

    Menu updateMenu(Menu menu);

    String deleteMenu(Menu menu);
}
