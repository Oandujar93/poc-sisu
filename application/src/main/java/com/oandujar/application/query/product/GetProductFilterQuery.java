package com.oandujar.application.query.product;

import com.oandujar.application.querybus.Query;
import com.oandujar.domain.entity.Product;
import com.oandujar.domain.filter.ProductFilter;
import com.oandujar.domain.shared.PageItems;

public class GetProductFilterQuery extends Query<PageItems<Product>> {

    private final ProductFilter filter;

    private GetProductFilterQuery(ProductFilter filter) {
        this.filter = filter;
    }

    public ProductFilter filter() {
        return filter;
    }

    public static class Builder {

        private ProductFilter filter;

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder create(ProductFilter filter) {
            this.filter = filter;
            return this;
        }

        public GetProductFilterQuery build() {
            return new GetProductFilterQuery(filter);
        }

    }

}
