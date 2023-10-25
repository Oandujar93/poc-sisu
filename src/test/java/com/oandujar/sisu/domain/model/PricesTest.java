package com.oandujar.sisu.domain.model;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PricesTest {

    @Test
    void create() {
        OffsetDateTime now = OffsetDateTime.now();
        Prices prices = Prices.create(1L, now, now, 1L, 2.0, "EUR", 1L, 1L, 1);
        assertNotNull(prices);
        assertEquals(1L, prices.getId());
        assertEquals(now, prices.getStartDate());
        assertEquals(now, prices.getEndDate());
        assertEquals(1L, prices.getBrandId());
        assertEquals(2.0, prices.getPrice());
        assertEquals("EUR", prices.getCurrency());
        assertEquals(1L, prices.getProductId());
    }
}