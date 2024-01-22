package com.oandujar.domain.repository;

import com.oandujar.domain.entity.Product;
import com.oandujar.domain.filter.ProductFilter;
import com.oandujar.domain.shared.PageItems;

import java.util.Optional;

public interface ProductRepository {
    Optional<Product> searchProductById(Long productId);

    PageItems<Product> searchPaginatedProductsByFilter(ProductFilter filter);
}
