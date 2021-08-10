package com.sales.smartphones.service;

import com.sales.smartphones.exception.AmountNotValideException;
import com.sales.smartphones.exception.MarkNotInformedException;
import com.sales.smartphones.exception.ProductNotFoundException;
import com.sales.smartphones.model.Product;
import com.sales.smartphones.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    public List<Product> listAll() {
        return productRepository.findAll();
    }

    public Product read(Long id){
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        }
        throw new ProductNotFoundException("Produto com id não encontrado");
    }

    public Product create(Product product) {
        if (product.getMark() == null) {
            throw new MarkNotInformedException("Marca não inserida");
        }
        return productRepository.save(product);
    }

    public void delete(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ProductNotFoundException("Produto com id não encontrado");
        }
        productRepository.deleteById(id);
    }

    public Product update(Long id, Product newProduct) {
        if (newProduct.getMark() == null) {
            throw new MarkNotInformedException("Marca não inserida");
        }
        if(newProduct.getAmount()<0){
            throw new AmountNotValideException("Campo amount negativo");
        }
        Optional<Product> productData = productRepository.findById(id);
        if (productData.isPresent()) {
            Product product = productData.get();
            product.setMark(newProduct.getMark());
            product.setAmount(newProduct.getAmount());
            product.setModel(newProduct.getModel());
            product.setColor(newProduct.getColor());
            product.setPrice(newProduct.getPrice());
            return productRepository.save(product);
        }
        throw new ProductNotFoundException("Produto com id não encontrado, impossivel salvar novo produto");
    }
}
