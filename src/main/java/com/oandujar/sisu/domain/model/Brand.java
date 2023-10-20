package com.oandujar.sisu.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
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

}

