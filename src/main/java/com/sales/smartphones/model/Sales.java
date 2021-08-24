package com.sales.smartphones.model;

import com.sales.smartphones.model.enums.Status;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name="sales")
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date buyDate;
    private Date deliveryDate;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @OneToOne
    @JoinColumn(name ="id_customer")
    private Customer idCustomer;

    @OneToOne
    @JoinColumn(name ="id_product")
    private Product idProduct;
}
