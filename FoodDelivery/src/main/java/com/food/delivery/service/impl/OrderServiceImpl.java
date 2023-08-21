package com.food.delivery.service.impl;

import com.food.delivery.entity.*;
import com.food.delivery.model.request.*;
import com.food.delivery.model.request.OrderItemDTO;
import com.food.delivery.model.request.PlaceOrderRequest;
import com.food.delivery.repository.MenuRepository;
import com.food.delivery.repository.OrderRepository;
import com.food.delivery.repository.VendorRepository;
import com.food.delivery.service.OrderService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Z003YZ0D Akshay Sahu
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
        private OrderRepository orderRepository;

        @Autowired
        private VendorRepository userRepository;
    @Autowired
    ModelMapper modelMapper;
        @Autowired
        private MenuRepository foodItemRepository;

        @Override
        public OrderDTO placeOrder(PlaceOrderRequest placeOrderRequest) {
            Vendor user = userRepository.findById(placeOrderRequest.getUserId())
                    .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + placeOrderRequest.getUserId()));

            List<OrderItemRequest> orderRequestItems = placeOrderRequest.getItems();
            List<OrderItemDTO> orderItemDTOs = Arrays.asList(modelMapper.map(orderRequestItems, OrderItemDTO[].class));
            List<OrderItem> orderItems = new ArrayList<>();
            Order order = new Order();
            order.setUser(user);
            double totalOrderPrice = 0.0;
            for (OrderItemDTO orderItemDTO : orderItemDTOs) {
                Menu foodItem = foodItemRepository.findById(orderItemDTO.getItemId())
                        .orElseThrow(() -> new EntityNotFoundException("Food item not found with id: " + orderItemDTO.getItemId()));

                OrderItem orderItem = new OrderItem();
                orderItem.setFoodItem(foodItem);
                orderItem.setQuantity(orderItemDTO.getQuantity());
                orderItems.add(orderItem);
                orderItem.setOrder(order);
                totalOrderPrice += foodItem.getPrice() * orderItemDTO.getQuantity();
            }


            order.setOrderItems(orderItems);
            order.setTotalPrice(totalOrderPrice);

            orderRepository.save(order);

            return convertToDTO(order);
        }

        private OrderDTO convertToDTO(Order order) {
            OrderDTO dto = new OrderDTO();
            dto.setId(order.getId());
            List<OrderItemDTO> orderItemDTOs = order.getOrderItems().stream()
                    .map(this::convertToOrderItemDTO)
                    .collect(Collectors.toList());
            dto.setOrderItems(orderItemDTOs);
            dto.setTotalPrice(order.getTotalPrice());
            return dto;
        }

        private OrderItemDTO convertToOrderItemDTO(OrderItem orderItem) {
            OrderItemDTO dto = new OrderItemDTO();
            dto.setItemId(orderItem.getId());
            dto.setFoodItem(convertToDTO(orderItem.getFoodItem()));
            dto.setQuantity(orderItem.getQuantity());
            return dto;
        }

    private MenuDto convertToDTO(Menu menu) {
        MenuDto menuDto = MenuDto.builder()
                .id(menu.getId())
                .description(menu.getDescription())
                .name(menu.getName())
                .price(menu.getPrice())
                .vendorId(menu.getVendor().getId())
                .build();
        menuDto.setDescription(menu.getDescription());
        return menuDto;
    }
    }
