package com.oandujar.domain.usecases;


import com.oandujar.domain.entity.Product;
import com.oandujar.domain.filter.ProductFilter;
import com.oandujar.domain.shared.PageItems;

import java.util.Optional;

public interface SearchProductUseCase {

    Optional<Product> searchProductById(Long productId);

    PageItems<Product> searchPaginatedProductsByFilter(ProductFilter filter);
}
