package com.oandujar.application.usecase;

import com.oandujar.application.query.product.GetProductByIdQuery;
import com.oandujar.application.query.product.GetProductFilterQuery;
import com.oandujar.application.querybus.QueryBus;
import com.oandujar.domain.entity.Product;
import com.oandujar.domain.exception.BusinessErrorType;
import com.oandujar.domain.exception.BusinessException;
import com.oandujar.domain.exception.InfraErrorType;
import com.oandujar.domain.exception.InfraException;
import com.oandujar.domain.filter.ProductFilter;
import com.oandujar.domain.shared.PageItems;
import com.oandujar.domain.usecases.SearchProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SearchProductUseCaseImpl implements SearchProductUseCase {

    private final QueryBus queryBus;

    @Override
    public Optional<Product> searchProductById(Long productId) {
        GetProductByIdQuery query = GetProductByIdQuery.Builder.getInstance()
                .create(productId)
                .build();
        Optional<Product> result;
        try {
            result = queryBus.handle(query);
        } catch (Exception e) {
            throw new InfraException(InfraErrorType.ORM_CONNECTION_ERROR);
        }

        if (result == null || !result.isPresent()) {
            throw new BusinessException(BusinessErrorType.PRODUCT_NOT_FOUND);
        }

        return result;
    }

    @Override
    public PageItems<Product> searchPaginatedProductsByFilter(ProductFilter filter) {
        GetProductFilterQuery query = GetProductFilterQuery.Builder.getInstance()
                .create(filter)
                .build();
        PageItems<Product> result;
        try {
            result = queryBus.handle(query);
        } catch (Exception e) {
            throw new InfraException(InfraErrorType.ORM_CONNECTION_ERROR);
        }

        if (result == null) {
            throw new BusinessException(BusinessErrorType.PRODUCT_NOT_FOUND);
        }

        return result;
    }

}
