package com.sales.smartphones.controller;

import com.sales.smartphones.model.products;
import com.sales.smartphones.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping()
    public List<products> listar() {
        return productRepository.findAll();
    }

    @PostMapping()
    public products addi(@RequestBody products product){
        return productRepository.save(product);
    }
}