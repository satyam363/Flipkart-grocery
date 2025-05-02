package com.flipkart.grocery.controller;

import com.flipkart.grocery.dto.AddInventoryRequest;
import com.flipkart.grocery.dto.AddItemRequest;
import com.flipkart.grocery.dto.SearchRequest;
import com.flipkart.grocery.model.Inventory;
import com.flipkart.grocery.model.Item;
import com.flipkart.grocery.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/allItems")
    public List<Item> getAllItems() {
        return inventoryService.getAllItems();
    }

    @PostMapping("/addItem")
    public Item addItem(@RequestBody AddItemRequest addItemRequest) {
        return inventoryService.addItem(addItemRequest.getCategory(), addItemRequest.getBrand(), addItemRequest.getPrice());
    }

    @PostMapping("/addStock")
    public Inventory addInventory(@RequestBody AddInventoryRequest addInventoryRequest) {
        return inventoryService.addInventory(addInventoryRequest.getCategory(), addInventoryRequest.getBrand(), addInventoryRequest.getQuantity());
    }

    @PostMapping("/search")
    public List<Inventory> searchItems(@RequestBody SearchRequest request) {
        return inventoryService.searchItems(request.getSearchFilter(), request.getSortOption());
    }
}
