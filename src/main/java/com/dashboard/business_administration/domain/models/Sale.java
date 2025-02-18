package com.dashboard.business_administration.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "sale")
@Getter
@Setter
@ToString
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;
    private String description;
    private Integer quantities;

    @Column(name = "creation_date")
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Sale() {
        this.creationDate = new Date();
    }

    public Sale(Double price, String description, Integer quantities) {
        this();
        this.price = price;
        this.description = description;
        this.quantities = quantities;
    }

    public Sale(Double price, String description, Integer quantities, Category category) {
        this();
        this.price = price;
        this.description = description;
        this.quantities = quantities;
        this.category = category;
    }
}
