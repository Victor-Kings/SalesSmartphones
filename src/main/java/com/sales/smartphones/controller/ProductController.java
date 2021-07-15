package com.sales.smartphones.controller;

import com.sales.smartphones.model.Product;
import com.sales.smartphones.service.ProductServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity <Product> read(@PathVariable("id") Long id) {
        Optional <Product> product = productServices.read(id);
        if(product.isPresent()){
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        }else return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping()
    public Product create(@RequestBody Product product){
        return productServices.create(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <HttpStatus>  delete(@PathVariable("id") Long id){
        try {
            productServices.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity <HttpStatus> update(@PathVariable("id") Long id, @RequestBody Product product){
        try {
            productServices.update(id, product);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}