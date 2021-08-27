package com.sales.smartphones.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Data
@Entity(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Pattern(regexp="[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}")
    private String cpf;
    private String address;//TODO: outra tabela para endereço
    private String phone;
}
