package com.flipkart.grocery.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private String brand;
    private Double price;
    private Integer quantity;

    public Item(String category, String brand, Double price) {
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.quantity = 0;
    }
}
