package com.sales.smartphones.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mark;
    private int amount;
    private String model;
    private String color;
    private Float price;

    @ManyToOne
    @JoinColumn(name ="id_sales")
    private Sales sale;
}
