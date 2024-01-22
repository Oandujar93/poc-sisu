package com.oandujar.application.query.product;


import com.oandujar.application.querybus.QueryHandler;
import com.oandujar.domain.entity.Product;
import com.oandujar.domain.repository.ProductRepository;
import com.oandujar.domain.shared.PageItems;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetProductFilterQueryHandler implements QueryHandler<PageItems<Product>, GetProductFilterQuery> {

    private final ProductRepository productRepository;

    @Override
    public PageItems<Product> handle(GetProductFilterQuery query) {
        return productRepository.searchPaginatedProductsByFilter(query.filter());
    }
}
