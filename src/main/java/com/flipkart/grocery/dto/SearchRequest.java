package com.flipkart.grocery.dto;

import com.flipkart.grocery.web.SearchFilter;
import com.flipkart.grocery.web.SortOption;
import lombok.Data;

@Data
public class SearchRequest {

    private SearchFilter searchFilter = new SearchFilter();
    private SortOption sortOption = new SortOption();

}
