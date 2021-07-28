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

    public ResponseEntity<Product> read(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Product> create(Product product) {
        if (product.getMark() == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productRepository.save(product), HttpStatus.OK);
    }

    public ResponseEntity<HttpStatus> delete(Long id) {
        try {
            productRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Product> update(Long id, Product newProduct) {
        if (newProduct.getMark() == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Optional<Product> productData = productRepository.findById(id);
        if (productData.isPresent()) {
            Product product = productData.get();
            product.setMark(newProduct.getMark());
            product.setAmount(newProduct.getAmount());
            product.setModel(newProduct.getModel());
            product.setColor(newProduct.getColor());
            product.setPrice(newProduct.getPrice());
            return new ResponseEntity<>(productRepository.save(product), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
