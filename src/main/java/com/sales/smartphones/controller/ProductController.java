package com.sales.smartphones.controller;

import com.sales.smartphones.model.Product;
import com.sales.smartphones.service.ProductService;
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
    private final ProductService productServices;// = new ProductServices();

//    public ProductController(ProductServices productServices){
//        this.productServices = productServices;
//    }

    @GetMapping()
    public List<Product> listAll() {
        return productServices.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> read(@PathVariable Long id) {
        Product product = productServices.read(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping()
    public ResponseEntity<Product>  create(@RequestBody Product product) {
        Product productRet = productServices.create(product);
        return ResponseEntity.ok(productRet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        productServices.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        Product productRet = productServices.update(id, product);
        return ResponseEntity.ok(productRet);
    }
}