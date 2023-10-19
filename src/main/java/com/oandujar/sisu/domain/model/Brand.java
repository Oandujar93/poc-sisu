package com.oandujar.sisu.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public Brand() {}

    private Brand(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Brand create(Long id, String name) {
        return new Brand(id, name);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name=" + name +
                "}";
    }
}
