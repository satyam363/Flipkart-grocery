package com.flipkart.grocery.dto;

import lombok.Data;

@Data
public class AddItemRequest {

    private String category;
    private String brand;
    private double price;

}
