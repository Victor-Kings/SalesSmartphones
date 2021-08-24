package com.sales.smartphones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<com.sales.smartphones.model.Sales,Long> {
}
