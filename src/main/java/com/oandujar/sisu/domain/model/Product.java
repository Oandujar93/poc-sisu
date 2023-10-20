package com.oandujar.sisu.domain.model;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public Product() {
    }

    private Product(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public static Product create(Long id, String name, String description) {
        return new Product(id, name, description);
    }

}
