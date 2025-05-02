package com.flipkart.grocery.repository;

import com.flipkart.grocery.model.Inventory;
import com.flipkart.grocery.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Inventory findByItem(Item item);
}
