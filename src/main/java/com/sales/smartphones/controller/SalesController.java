package com.sales.smartphones.controller;
import com.sales.smartphones.model.Sales;
import com.sales.smartphones.service.SalesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
@AllArgsConstructor
public class SalesController {

    private final SalesService salesService;

    @PostMapping()
    public ResponseEntity<Sales> create(@RequestBody Sales sales) {
        Sales salesRet = salesService.create(sales);
        return ResponseEntity.ok(salesRet);
    }
}
