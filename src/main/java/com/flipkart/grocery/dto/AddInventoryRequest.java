package com.flipkart.grocery.dto;

import lombok.Data;

@Data
public class AddInventoryRequest {

    private String category;
    private String brand;
    private int quantity;

}
