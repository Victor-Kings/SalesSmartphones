package com.sales.smartphones.service;

import com.sales.smartphones.exception.MarkNotInformedException;
import com.sales.smartphones.model.Customer;
import com.sales.smartphones.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public Customer create(Customer customer) {
        if (customer.getName() == null) {
            throw new MarkNotInformedException("Nome não inserido");
        }
        return customerRepository.save(customer);
    }
}
