package com.sales.smartphones.service;

import com.sales.smartphones.model.Sales;
import com.sales.smartphones.repository.SalesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SalesServiceImpl implements SalesService{
    private final SalesRepository salesRepository;

    public Sales create(Sales sales) {
//        if (sales.getProducts() == null) {
//            throw new MarkNotInformedException("Product não inserido");
//        }
        return salesRepository.save(sales);
    }
}
