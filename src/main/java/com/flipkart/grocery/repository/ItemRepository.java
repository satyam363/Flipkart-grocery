package com.flipkart.grocery.repository;

import com.flipkart.grocery.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findByCategoryAndBrand(String category, String brand);
}
