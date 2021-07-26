package com.sales.smartphones.controller;

import com.sales.smartphones.model.Product;
import com.sales.smartphones.service.ProductServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    //    @Autowired
//    private ProductRepository productRepository;
    private final ProductServices productServices;// = new ProductServices();

//    public ProductController(ProductServices productServices){
//        this.productServices = productServices;
//    }

    @GetMapping()
    public List<Product> listAll() {
        return productServices.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> read(@PathVariable("id") Long id) {
        return productServices.read(id);
    }

    @PostMapping()
    public ResponseEntity<Product>  create(@RequestBody Product product) {
        return productServices.create(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        return productServices.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        return productServices.update(id, product);
    }
}