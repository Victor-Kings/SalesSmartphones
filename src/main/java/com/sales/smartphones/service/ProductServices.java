package com.sales.smartphones.service;

import com.sales.smartphones.model.Product;
import com.sales.smartphones.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServices {
    private final ProductRepository productRepository;

    public List<Product> listAll() {
        return productRepository.findAll();
    }
    public Optional<Product> read(Long id) {
        return productRepository.findById(id);
    }

    public Product create(Product product){
        return productRepository.save(product);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }
    public ResponseEntity<Product> update(Long id, Product newProduct){
        Optional <Product> productData = productRepository.findById(id);
        if(productData.isPresent()){
            Product product = productData.get();
            product.setMark(newProduct.getMark());
            return new ResponseEntity<>( productRepository.save(product), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
