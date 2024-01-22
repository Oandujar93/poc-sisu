package com.oandujar.application.query.product;


import com.oandujar.application.querybus.QueryHandler;
import com.oandujar.domain.entity.Product;
import com.oandujar.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetProductByIdQueryHandler implements QueryHandler<Optional<Product>, GetProductByIdQuery> {

    private final ProductRepository productRepository;

    @Override
    public Optional<Product> handle(GetProductByIdQuery query) {
        return productRepository.searchProductById(query.productId());
    }
}
