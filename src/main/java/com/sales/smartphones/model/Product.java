package com.sales.smartphones.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="product")
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mark;
    private int amount;
    private String model;
    private String color;
    private Float price;
}
