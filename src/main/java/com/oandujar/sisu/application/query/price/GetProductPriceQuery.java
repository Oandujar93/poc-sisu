package com.oandujar.sisu.application.query.price;

import com.oandujar.sisu.application.dto.response.ProductPriceFeeQueryResponse;
import com.oandujar.sisu.application.querybus.Query;

import java.time.OffsetDateTime;

public class GetProductPriceQuery extends Query<ProductPriceFeeQueryResponse> {

    private final Long productId;
    private final Long brandId;
    private final OffsetDateTime offsetDateTime;

    private GetProductPriceQuery(Long productId, Long brandId, OffsetDateTime offsetDateTime) {
        this.productId = productId;
        this.brandId = brandId;
        this.offsetDateTime = offsetDateTime;
    }

    public Long productId() {
        return productId;
    }

    public Long brandId() {
        return brandId;
    }

    public OffsetDateTime offsetDateTime () {
        return offsetDateTime;
    }

    public static class Builder {

        private Long productId;
        private Long brandId;
        private OffsetDateTime offsetDateTime;

        public static GetProductPriceQuery.Builder getInstance() {
            return new GetProductPriceQuery.Builder();
        }

        public GetProductPriceQuery.Builder create(Long productId, Long brandId, OffsetDateTime offsetDateTime) {
            this.productId = productId;
            this.brandId = brandId;
            this.offsetDateTime = offsetDateTime;
            return this;
        }

        public GetProductPriceQuery build() {
            return new GetProductPriceQuery(productId, brandId, offsetDateTime);
        }




    }
}
