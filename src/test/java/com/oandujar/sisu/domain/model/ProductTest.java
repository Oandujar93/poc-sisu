package com.oandujar.sisu.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void create() {
        Product product = Product.create(1L, "product", "description");
        assertNotNull(product);
        assertEquals(1L, product.getId());
        assertEquals("product", product.getName());
        assertEquals("description", product.getDescription());
    }
}