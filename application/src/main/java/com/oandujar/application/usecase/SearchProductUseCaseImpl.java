package com.oandujar.application.usecase;

import com.oandujar.domain.entity.Product;
import com.oandujar.domain.exception.BusinessErrorType;
import com.oandujar.domain.exception.BusinessException;
import com.oandujar.domain.filter.ProductFilter;
import com.oandujar.domain.repository.ProductRepository;
import com.oandujar.domain.shared.PageItems;
import com.oandujar.domain.usecases.SearchProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SearchProductUseCaseImpl implements SearchProductUseCase {

    private final ProductRepository productRepository;

    @Override
    public Optional<Product> searchProductById(Long productId) {
        Optional<Product> result = productRepository.searchProductById(productId);

        if (result == null || !result.isPresent()) {
            throw new BusinessException(BusinessErrorType.PRODUCT_NOT_FOUND, String.valueOf(productId));
        }

        return result;
    }

    @Override
    public PageItems<Product> searchPaginatedProductsByFilter(ProductFilter filter) {
        PageItems<Product> result = productRepository.searchPaginatedProductsByFilter(filter);

        if (result == null) {
            throw new BusinessException(BusinessErrorType.PRODUCT_NOT_FOUND, String.valueOf(filter.getProductId()));
        }

        return result;
    }

}
