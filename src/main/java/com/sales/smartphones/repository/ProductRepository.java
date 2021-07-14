package com.sales.smartphones.repository;

import com.sales.smartphones.model.products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<products, Long> {
}
