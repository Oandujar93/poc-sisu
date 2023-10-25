package com.oandujar.sisu.application.mapper;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class ProductPriceMapperTest {

    private final ProductPriceMapper productPriceMapper = Mappers.getMapper(ProductPriceMapper.class);

    @Test
    void priceToDecimalString_null() {
        String result = productPriceMapper.priceToDecimalString(null);
        assertNull(result);
    }

    @Test
    void priceToDecimalString_not_null() {
        String result = productPriceMapper.priceToDecimalString(2.0);
        assertNotNull(result);
    }
}