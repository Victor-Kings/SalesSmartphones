package com.sales.smartphones.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Setter
@Entity(name="address")
public class Address {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idAddress")
    @Setter(value= AccessLevel.NONE)
    private int id;

    @Pattern(regexp="^[0-9]{5}-[0-9]{3}")
    @Size(min=9,max = 9)
    private String cep;

    @Size(min=2,max=2)
    private String state;

    private String city;

    private String neighborhood;

    private String street;

    private String number;
}
