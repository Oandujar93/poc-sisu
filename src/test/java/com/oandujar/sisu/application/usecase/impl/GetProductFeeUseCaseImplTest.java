package com.oandujar.sisu.application.usecase.impl;

import com.oandujar.sisu.application.dto.response.ProductPriceFeeQueryResponse;
import com.oandujar.sisu.application.query.price.GetProductPriceQuery;
import com.oandujar.sisu.application.querybus.Query;
import com.oandujar.sisu.application.querybus.QueryBus;
import com.oandujar.sisu.infrastructure.exception.NotFoundException;
import com.oandujar.sisu.infrastructure.exception.ORMException;
import com.oandujar.sisu.web.api.model.ProductPriceResponse;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetProductFeeUseCaseImplTest {

    private Long brandId;
    private Long productId;
    private OffsetDateTime offsetDateTime;


    @InjectMocks
    private GetProductFeeUseCaseImpl getProductFeeUseCase;

    @Mock
    private GetProductPriceQuery query;
    @Mock
    private QueryBus queryBus;
    @Mock
    private ProductPriceFeeQueryResponse productPriceFeeQueryResponse;

    @BeforeEach
    void setUp() {
        brandId = 1L;
        productId = 35455L;
        offsetDateTime = OffsetDateTime.now();
    }

    @SneakyThrows
    @Test
    void execute_ok() {
        when(queryBus.handle(any(Query.class))).thenReturn(productPriceFeeQueryResponse);
        ProductPriceResponse productPriceResponse = getProductFeeUseCase.execute(brandId, productId, offsetDateTime);
        assertNotNull(productPriceResponse);
        assertEquals(productPriceFeeQueryResponse.getProductId(), productPriceResponse.getProductId());
        assertEquals(productPriceFeeQueryResponse.getPriceList(), productPriceResponse.getFee());
        assertEquals(productPriceFeeQueryResponse.getBrandId(), productPriceResponse.getBrandId());
        assertEquals(productPriceFeeQueryResponse.getStartDate(), productPriceResponse.getStartDate());
        assertEquals(productPriceFeeQueryResponse.getEndDate(), productPriceResponse.getEndDate());
        assertEquals(productPriceFeeQueryResponse.getPrice(), productPriceResponse.getPrice());
        assertEquals(productPriceFeeQueryResponse.getCurrency(), productPriceResponse.getCurrency());
        assertEquals(productPriceFeeQueryResponse.getPriority(), productPriceResponse.getPriority());
    }

    @SneakyThrows
    @Test
    void execute_throws_not_found() {
        when(queryBus.handle(any(Query.class))).thenReturn(null);
        assertThrows(NotFoundException.class, () -> getProductFeeUseCase.execute(brandId, productId, offsetDateTime));
    }

    @SneakyThrows
    @Test
    void execute_throws_orm_exception() {
        when(queryBus.handle(any(Query.class))).thenThrow(new RuntimeException());
        assertThrows(ORMException.class, () -> getProductFeeUseCase.execute(brandId, productId, offsetDateTime));
    }
}