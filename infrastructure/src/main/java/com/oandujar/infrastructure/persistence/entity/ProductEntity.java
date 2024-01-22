package com.oandujar.infrastructure.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "brand_id")
    private Long brandId;

    @ManyToOne
    @JoinColumn(name = "brand_id", insertable = false, updatable = false)
    private BrandEntity brand;

    @OneToMany(mappedBy = "product")
    private Set<PricesEntity> prices = new LinkedHashSet<>();

}
