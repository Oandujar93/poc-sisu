package com.oandujar.sisu.domain.model;

import javax.persistence.*;

@Entity
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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name=" + name +
                ", description=" + description +
                '}';
    }
}
