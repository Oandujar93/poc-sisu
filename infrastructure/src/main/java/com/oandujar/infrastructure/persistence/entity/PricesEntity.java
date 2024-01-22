package com.oandujar.infrastructure.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "prices")
public class PricesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    private OffsetDateTime startDate;

    @Column(name = "end_date")
    private OffsetDateTime endDate;

    @Column(name = "fee")
    private Long fee;

    @Column(name = "price")
    private Double price;

    @Column(name = "currency")
    private String currency;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "product_id")
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private ProductEntity product;

}

