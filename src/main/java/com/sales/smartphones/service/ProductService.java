package com.sales.smartphones.service;

import com.sales.smartphones.model.Product;

import java.util.List;

public interface ProductService {
     List<Product> listAll();

     Product read(Long id);

    Product create(Product product);

     void delete(Long id);

     Product update(Long id, Product newProduct);
}
