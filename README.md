# Flipkart-grocery
A Spring Boot application that provides users a way to browse grocery inventory using multiple filters and sorting options. Built with extensibility, modularity, and testability in mind.

**Features**
1. Add new items to inventory (category, brand, price)
2. Add stock quantity to existing items
3. Search inventory using:
    Category filter
    Brand filter
    Price range
    Any combination of the above
4. Sort results by:
    Price (asc/desc)
    Quantity (asc/desc)
5. Unit tested using JUnit 5
6. Uses in-memory H2 database
7. Easily extensible for new filters/sorting

**Tech Stack**
1. Java 17+
2. Spring Boot 3+
3. Spring Data JPA
4. H2 Database
5. Maven
6.JUnit 5

**Sample API calls**
1. Add Item : POST inventory/addItem
2. Add Stock : POST inventory/addStock
3. Get all items : GET inventory/allItems
4. Search Inventory : POST inventory/search

**Future Enhancements**
1. Add UI (React/Angular)
2. Add pagination support
3. Support expiration dates for items
4. Enable caching using Redis
5. Integrate order placement & checkout
