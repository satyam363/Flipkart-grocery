package com.flipkart.grocery.service;

import com.flipkart.grocery.exception.ItemExistException;
import com.flipkart.grocery.exception.ItemNotCreatedException;
import com.flipkart.grocery.exception.ItemNotExistsException;
import com.flipkart.grocery.model.Inventory;
import com.flipkart.grocery.model.Item;
import com.flipkart.grocery.repository.InventoryRepository;
import com.flipkart.grocery.repository.ItemRepository;
import com.flipkart.grocery.web.SearchFilter;
import com.flipkart.grocery.web.SortField;
import com.flipkart.grocery.web.SortOption;
import com.flipkart.grocery.web.SortOrder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InventoryServiceImpl implements InventoryService{

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item addItem(String category, String brand, Double price) {
        Item item = itemRepository.findByCategoryAndBrand(category, brand);
        if(item != null)
            throw new ItemExistException("Item already exists");
        return itemRepository.save(new Item(category, brand, price));
    }

    @Override
    public Inventory addInventory(String category, String brand, Integer quantity) {
        Item item = itemRepository.findByCategoryAndBrand(category, brand);
        if(item == null)
            throw new ItemNotExistsException("Item not present");
        Inventory inventory = inventoryRepository.findByItem(item);
        if(inventory == null) {
            return inventoryRepository.save(new Inventory(item, quantity));
        }
        inventory.setQuantity(inventory.getQuantity() + quantity);
        return inventoryRepository.save(inventory);
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> list = itemRepository.findAll();
        if(list.isEmpty())
            throw new ItemNotCreatedException("Item not created yet, please add some items !!");
        return list;
    }

    @Override
    public List<Inventory> searchItems(SearchFilter searchFilter, SortOption sortOption) {
        List<Inventory> list = inventoryRepository.findAll();
        return list.stream()
                .filter(inventory -> searchFilter.getCategories().isEmpty() || searchFilter.getCategories().contains(inventory.getItem().getCategory()))
                .filter(inventory -> searchFilter.getBrands().isEmpty() || searchFilter.getBrands().contains(inventory.getItem().getBrand()))
                .filter(inventory -> searchFilter.getPriceFrom() == null || inventory.getItem().getPrice() >= searchFilter.getPriceFrom())
                .filter(inventory -> searchFilter.getPriceTo() == null || inventory.getItem().getPrice() <= searchFilter.getPriceTo())
                .sorted(getComparator(sortOption))
                .collect(Collectors.toList());
    }

    public Comparator<Inventory> getComparator(SortOption sortOption) {
        Comparator<Inventory> comparator;
        if(sortOption.getSortField() == SortField.QUANTITY)
            comparator = Comparator.comparingInt(Inventory::getQuantity);
        else
            comparator = Comparator.comparingDouble(i -> i.getItem().getPrice());
        return sortOption.getSortOrder() == SortOrder.DESC ? comparator.reversed() : comparator;
    }
}
