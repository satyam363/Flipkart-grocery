package com.flipkart.grocery.web;

import lombok.Data;

@Data
public class SortOption {

    private SortField sortField = SortField.PRICE;
    private SortOrder sortOrder = SortOrder.ASC;

}
