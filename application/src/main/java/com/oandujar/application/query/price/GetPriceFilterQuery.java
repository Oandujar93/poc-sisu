package com.oandujar.application.query.price;

import com.oandujar.application.querybus.Query;
import com.oandujar.domain.entity.Prices;
import com.oandujar.domain.entity.Product;
import com.oandujar.domain.filter.PriceFilter;
import com.oandujar.domain.filter.ProductFilter;
import com.oandujar.domain.shared.PageItems;

import java.util.Optional;

public class GetPriceFilterQuery extends Query<Optional<Prices>> {

    private final PriceFilter filter;

    private GetPriceFilterQuery(PriceFilter filter) {
        this.filter = filter;
    }

    public PriceFilter filter() {
        return filter;
    }

    public static class Builder {

        private PriceFilter filter;

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder create(PriceFilter filter) {
            this.filter = filter;
            return this;
        }

        public GetPriceFilterQuery build() {
            return new GetPriceFilterQuery(filter);
        }

    }

}
