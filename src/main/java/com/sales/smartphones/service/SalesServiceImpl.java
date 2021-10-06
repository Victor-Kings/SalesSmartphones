package com.sales.smartphones.service;

import com.sales.smartphones.DTO.SalesDTO;
import com.sales.smartphones.exception.CustomerNotFoundException;
import com.sales.smartphones.exception.ProductNotFoundException;
import com.sales.smartphones.model.Customer;
import com.sales.smartphones.model.Product;
import com.sales.smartphones.model.Sales;
import com.sales.smartphones.model.enums.Status;
import com.sales.smartphones.repository.CustomerRepository;
import com.sales.smartphones.repository.ProductRepository;
import com.sales.smartphones.repository.SalesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SalesServiceImpl implements SalesService{
    private final SalesRepository salesRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    public Sales create(SalesDTO salesDTO) {
        Sales sales = new Sales();

        Optional <Customer> customer = customerRepository.findById(salesDTO.getCustomerId());
        if(customer.isPresent()) {
            sales.setCustomerId(customer.get());
        }else{
            throw new CustomerNotFoundException("id do Customer não encontrado");
        }

        List<Product> products = createListProducts(salesDTO);

        sales.setProductsId(products);

        sales.setBuyDate(LocalDateTime.now());

        sales.setStatus(Status.AGUARDANDO_PAGAMENTO);

        return salesRepository.save(sales);
    }
    private  List<Product> createListProducts(SalesDTO salesDTO){
        List<Product> products = new ArrayList<Product>();
        Optional<Product> product;
        for(Long productId : salesDTO.getProductsId()) {
            product = productRepository.findById(productId);
            if(product.isPresent()){
                products.add(product.get());
            }else{
                throw new ProductNotFoundException("Produto com id: "+productId+" não encontrado");
            }
        }
        return products;
    }
}
