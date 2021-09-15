package com.sales.smartphones.model;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name="product")
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String mark;

    @Range(min = 1)
    private int amount;

    @NotNull
    private String model;

    @NotNull
    private String color;

    @NotNull
    private Float price;
}
