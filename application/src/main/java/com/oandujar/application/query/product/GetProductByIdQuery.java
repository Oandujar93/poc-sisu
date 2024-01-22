package com.oandujar.application.query.product;

import com.oandujar.application.querybus.Query;
import com.oandujar.domain.entity.Product;

import java.util.Optional;

public class GetProductByIdQuery extends Query<Optional<Product>> {

    private final Long productId;

    private GetProductByIdQuery(Long productId) {
        this.productId = productId;
    }

    public Long productId() {
        return productId;
    }

    public static class Builder {

        private Long productId;

        public static GetProductByIdQuery.Builder getInstance() {
            return new GetProductByIdQuery.Builder();
        }

        public GetProductByIdQuery.Builder create(Long productId) {
            this.productId = productId;
            return this;
        }

        public GetProductByIdQuery build() {
            return new GetProductByIdQuery(productId);
        }

    }

}
