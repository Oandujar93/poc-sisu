package com.oandujar.sisu.application.usecase.impl;

import com.oandujar.sisu.application.dto.response.ProductPriceFeeQueryResponse;
import com.oandujar.sisu.application.mapper.ProductPriceMapper;
import com.oandujar.sisu.application.query.price.GetProductPriceQuery;
import com.oandujar.sisu.application.querybus.QueryBus;
import com.oandujar.sisu.domain.usecase.GetProductFeeUseCase;
import com.oandujar.sisu.infrastructure.exception.ErrorCode;
import com.oandujar.sisu.infrastructure.exception.NotFoundException;
import com.oandujar.sisu.infrastructure.exception.ORMException;
import com.oandujar.sisu.web.api.model.ProductPriceResponse;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class GetProductFeeUseCaseImpl implements GetProductFeeUseCase {

    private final QueryBus queryBus;
    private final ProductPriceMapper productPriceMapper = Mappers.getMapper(ProductPriceMapper.class);

    @Override
    public ProductPriceResponse execute(Long productId, Long brandId, OffsetDateTime offsetDateTime) {
        GetProductPriceQuery query = GetProductPriceQuery.Builder.getInstance()
                .create(productId, brandId, offsetDateTime)
                .build();
        ProductPriceFeeQueryResponse result;
        try {
            result = queryBus.handle(query);
        } catch (Exception e) {
            throw new ORMException(ErrorCode.ORM_ACCESS_ERROR, ErrorCode.ORM_ACCESS_ERROR.getMessage());
        }

        if (result == null) {
            throw new NotFoundException(ErrorCode.NOT_FOUND, ErrorCode.NOT_FOUND.getMessage());
        }

        return productPriceMapper.domainToDTO(result);
    }


}
