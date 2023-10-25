package com.oandujar.sisu.infraestructure.rest.controller;

import com.oandujar.sisu.domain.usecase.GetProductFeeUseCase;
import com.oandujar.sisu.web.api.model.ProductPriceResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PriceControllerTest {

    private Long brandId;
    private Long productId;
    private OffsetDateTime offsetDateTime;

    @InjectMocks
    private PriceController priceController;

    @Mock
    private GetProductFeeUseCase getProductFeeUseCase;
    @Mock
    private ProductPriceResponse productPriceResponse;

    @BeforeEach
    void setUp() {
        brandId = 1L;
        productId = 35455L;
        offsetDateTime = OffsetDateTime.now();
    }

    @Test
    void getProductPrice() {
        Mockito.when(getProductFeeUseCase.execute(productId, brandId, offsetDateTime)).thenReturn(productPriceResponse);
        ResponseEntity<ProductPriceResponse> result = priceController.getProductPrice(brandId, productId, offsetDateTime);
        assertEquals(productPriceResponse, result.getBody());
    }
}