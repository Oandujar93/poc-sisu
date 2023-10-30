package com.oandujar.sisu.infrastructure.port;

import com.oandujar.sisu.domain.model.Prices;
import com.oandujar.sisu.infrastructure.port.repository.PricesRepository;
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
class PricesPortImplTest {

    private Long brandId;
    private Long productId;
    private OffsetDateTime offsetDateTime;

    @InjectMocks
    private PricesPortImpl pricesPortImpl;

    @Mock
    private PricesRepository pricesRepository;
    @Mock
    private Prices prices;

    @BeforeEach
    void setUp() {
        brandId = 1L;
        productId = 35455L;
        offsetDateTime = OffsetDateTime.now();
    }

    @Test
    void findByBrandIdProductIdAndBetweenStartDateAndEndDate() {
        when(pricesRepository.findFirstByBrandIdProductIdAndBetweenStartDateAndEndDateOrderByPriority(
                anyLong(),
                anyLong(),
                any(OffsetDateTime.class))).thenReturn(Optional.of(prices));
        Optional<Prices> result = pricesPortImpl.findByBrandIdProductIdAndBetweenStartDateAndEndDate(brandId, productId, offsetDateTime);
        assertEquals(prices, result.get());
    }
}