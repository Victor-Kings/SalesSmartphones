package com.sales.smartphones.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity(name="sales")
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date buyDate;
    private Date deliveryDate;

  //  @Enumerated(EnumType.STRING)
    @Column(name = "status_sales")
    private String status;

    @OneToOne
    @JoinColumn(name ="id_customer")
    private Customer customer;

    @OneToMany
    @JoinColumn(name ="id_product")
    private List<Product> products;
}
