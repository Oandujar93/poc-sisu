package com.oandujar.sisu.application.dto.response;

import com.oandujar.sisu.domain.model.Prices;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Getter
@Builder
public class ProductPriceFeeQueryResponse implements Serializable {

    public static final String UNKONWN = "Unkonwn";

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

    private ProductPriceFeeQueryResponse(Long productId,
                                         String name,
                                         String description,
                                         Long brandId,
                                         String brand,
                                         Long priceList,
                                         OffsetDateTime startDate,
                                         OffsetDateTime endDate,
                                         String price,
                                         String currency,
                                         Integer priority) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.brandId = brandId;
        this.brand = brand;
        this.priceList = priceList;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.currency = currency;
        this.priority = priority;
    }

    public static ProductPriceFeeQueryResponse fromDomain(Prices prices) {
        return ProductPriceFeeQueryResponse.builder()
                .productId(prices.getProductId())
                .name(prices.getProduct() != null ? prices.getProduct().getName() : UNKONWN)
                .description(prices.getProduct() != null ? prices.getProduct().getDescription() : UNKONWN)
                .brandId(prices.getBrandId())
                .brand(prices.getBrand() != null ? prices.getBrand().getName() : UNKONWN)
                .priceList(prices.getPriceList() != null ? prices.getPriceList() : null)
                .startDate(prices.getStartDate())
                .endDate(prices.getEndDate())
                .price(prices.getPrice() != null ? prices.getPrice().toString() : null)
                .currency(prices.getCurrency())
                .priority(prices.getPriority())
                .build();
    }

}
