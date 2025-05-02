package com.flipkart.grocery.web;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class SearchFilter {

    private Set<String> categories = new HashSet<>();
    private Set<String> brands = new HashSet<>();
    private Double priceFrom;
    private Double priceTo;

}
