package com.flipkart.grocery.service;

import com.flipkart.grocery.model.Inventory;
import com.flipkart.grocery.model.Item;
import com.flipkart.grocery.web.SearchFilter;
import com.flipkart.grocery.web.SortOption;

import java.util.List;

public interface InventoryService {

    public Item addItem(String category, String brand, Double price);

    public Inventory addInventory(String category, String brand, Integer quantity);

    public List<Item> getAllItems();

    public List<Inventory> searchItems(SearchFilter searchFilter, SortOption sortOption);

}
