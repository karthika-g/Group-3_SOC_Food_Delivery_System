package com.food.delivery.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

/**
 * @author Z003YZ0D Akshay Sahu
 */
@Entity
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Menu foodItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Order order;

    private int quantity;
    // Other fields, getters, setters
}
