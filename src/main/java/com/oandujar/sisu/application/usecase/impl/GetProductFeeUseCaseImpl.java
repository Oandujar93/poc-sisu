package com.oandujar.sisu.application.usecase.impl;

import com.oandujar.sisu.application.query.price.GetProductPriceQuery;
import com.oandujar.sisu.application.querybus.QueryBus;
import com.oandujar.sisu.domain.usecase.GetProductFeeUseCase;
import com.oandujar.sisu.infraestructure.exception.ErrorCode;
import com.oandujar.sisu.infraestructure.exception.NotFoundException;
import com.oandujar.sisu.infraestructure.exception.ORMException;
import com.oandujar.sisu.web.api.model.ProductPriceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetProductFeeUseCaseImpl implements GetProductFeeUseCase {

    private final QueryBus queryBus;

    @Override
    public List<ProductPriceResponse> execute(Long productId, Long brandId, OffsetDateTime offsetDateTime) {
        GetProductPriceQuery query = GetProductPriceQuery.Builder.getInstance()
                .create(productId, brandId, offsetDateTime)
                .build();
        List<ProductPriceResponse> result;
        try {
            result = queryBus.handle(query);
        } catch (Exception e) {
            throw new ORMException(ErrorCode.ORM_ACCESS_ERROR, ErrorCode.ORM_ACCESS_ERROR.getMessage());
        }

        if (result == null || result.isEmpty()) {
            throw new NotFoundException(ErrorCode.NOT_FOUND, ErrorCode.NOT_FOUND.getMessage());
        }

        return result;
    }


}
