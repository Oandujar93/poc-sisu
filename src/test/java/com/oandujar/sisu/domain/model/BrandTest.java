package com.oandujar.sisu.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrandTest {

    @Test
    void create() {
        Brand brand = Brand.create(1L, "brand");
        assertNotNull(brand);
        assertEquals(1L, brand.getId());
        assertEquals("brand", brand.getName());
    }

}