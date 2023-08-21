package com.food.delivery.entity;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Z003YZ0D Akshay Sahu
 */
@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vendor user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<OrderItem> orderItems = new ArrayList<>();

    private double totalPrice;
    // Other fields, getters, setters
}

