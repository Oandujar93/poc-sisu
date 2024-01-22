package com.oandujar.infrastructure.rest.response;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Getter
@Builder
public class ProductPriceFeeQueryResponse implements Serializable {

    public static final String UNKNOWN = "Unknown";

    private final Long productId;
    private final String name;
    private final String description;
    private final Long brandId;
    private final String brand;
    private final Long priceList;
    private final OffsetDateTime startDate;
    private final OffsetDateTime endDate;
    private final String price;
    private final String currency;
    private final Integer priority;

}
