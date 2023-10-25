package com.oandujar.sisu.application.query.price;

import com.oandujar.sisu.application.dto.response.ProductPriceFeeQueryResponse;
import com.oandujar.sisu.domain.model.Prices;
import com.oandujar.sisu.domain.port.PricesPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class GetProductPriceQueryHandlerTest {

    private Long brandId;
    private Long productId;
    private OffsetDateTime offsetDateTime;
    private GetProductPriceQuery query;

    @InjectMocks
    private GetProductPriceQueryHandler getProductPriceQueryHandler;
    @Mock
    private PricesPort pricesPort;
    @Mock
    private Prices prices;

    @BeforeEach
    void setUp() {
        brandId = 1L;
        productId = 35455L;
        offsetDateTime = OffsetDateTime.now();

        query = GetProductPriceQuery.Builder.getInstance().create(brandId, productId, offsetDateTime).build();
    }

    @Test
    void handle_is_present() {
        when(pricesPort.findByBrandIdProductIdAndBetweenStartDateAndEndDate(anyLong(), anyLong(), any(OffsetDateTime.class)))
                .thenReturn(Optional.of(prices));
        ProductPriceFeeQueryResponse result = getProductPriceQueryHandler.handle(query);
        assertNotNull(result);
    }

    @Test
    void handle_is_not_present() {
        when(pricesPort.findByBrandIdProductIdAndBetweenStartDateAndEndDate(anyLong(), anyLong(), any(OffsetDateTime.class)))
                .thenReturn(Optional.empty());
        ProductPriceFeeQueryResponse result = getProductPriceQueryHandler.handle(query);
        assertNull(result);
    }
}