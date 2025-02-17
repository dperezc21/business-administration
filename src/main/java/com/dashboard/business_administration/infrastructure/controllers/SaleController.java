package com.dashboard.business_administration.infrastructure.controllers;

import com.dashboard.business_administration.application.use_cases.SaleUseCase;
import com.dashboard.business_administration.domain.models.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sales")
public class SaleController {

    @Autowired private SaleUseCase saleUseCase;

    @PostMapping
    public ResponseEntity<Sale> save(@RequestBody Sale sale) {
        Sale saleSaved = this.saleUseCase.saveSale(sale.getPrice(), sale.getDescription(), sale.getQuantities());
        return ResponseEntity.ok(saleSaved);
    }
}
