package com.flipkart.grocery;

import com.flipkart.grocery.model.Inventory;
import com.flipkart.grocery.model.Item;
import com.flipkart.grocery.service.InventoryService;
import com.flipkart.grocery.web.SearchFilter;
import com.flipkart.grocery.web.SortOption;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class GroceryApplicationTests {

	@Autowired
	private InventoryService inventoryService;

	@Test
	void testAddAndSearch() {
		inventoryService.addItem("Ice cream", "Amul", 200.0);
		inventoryService.addInventory("Ice cream", "Amul", 10);

		SearchFilter searchFilter = new SearchFilter();
		SortOption sortOption = new SortOption();
		searchFilter.getCategories().add("Ice cream");
		List<Inventory> list = inventoryService.searchItems(searchFilter, sortOption);

		assertEquals(1, list.size());
		assertEquals("Amul", list.get(0).getItem().getBrand());
	}

	@Test
	void testGetAllItems() {
		inventoryService.addItem("Ice cream", "Amul", 200.0);
		List<Item> list = inventoryService.getAllItems();

		assertNotNull(list, "Item list should not be null");
		assertEquals("Ice cream", list.getFirst().getCategory(), "Item category should match");
	}

}
