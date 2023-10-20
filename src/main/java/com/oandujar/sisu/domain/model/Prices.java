package com.oandujar.sisu.domain.model;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Getter
@ToString
@Table(name = "prices")
public class Prices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    private OffsetDateTime startDate;

    @Column(name = "end_date")
    private OffsetDateTime endDate;

    @Column(name = "price_list")
    private Long priceList;

    @Column(name = "price")
    private Double price;

    @Column(name = "currency")
    private String currency;

    @Column(name = "brand_id")
    private Long brandId;

    @ManyToOne
    @JoinColumn(name = "brand_id", insertable = false, updatable = false)
    private Brand brand;

    @Column(name = "product_id")
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    @Column(name = "priority")
    private Integer priority;

    public Prices() {
    }

    private Prices(Long id, OffsetDateTime startDate, OffsetDateTime endDate, Long priceList, Double price, String currency, Long brandId, Long productId, Integer priority) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.price = price;
        this.currency = currency;
        this.brandId = brandId;
        this.productId = productId;
        this.priority = priority;
    }

    public static Prices create(Long id, OffsetDateTime startDate, OffsetDateTime endDate, Long priceList, Double price, String currency, Long brandId, Long productId, Integer priority) {
        return new Prices(id, startDate, endDate, priceList, price, currency, brandId, productId, priority);
    }

}

