package com.dashboard.business_administration.infrastructure.controllers;

import com.dashboard.business_administration.application.use_cases.SaleUseCase;
import com.dashboard.business_administration.domain.exceptions.SaleNotFoundException;
import com.dashboard.business_administration.domain.models.Sale;
import com.dashboard.business_administration.domain.responses.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/sales")
public class SaleController {

    @Autowired private SaleUseCase saleUseCase;

    @PostMapping
    public ResponseEntity<Sale> save(@RequestBody Sale sale) {
        Sale saleSaved = this.saleUseCase.saveSale(sale.getPrice(), sale.getDescription(), sale.getQuantities());
        return ResponseEntity.ok(saleSaved);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Sale>> getSales() {
        List<Sale> saleList = this.saleUseCase.getListSale();
        return ResponseEntity.ok(saleList);
    }

    @GetMapping(value = "/{saleId}")
    public ResponseEntity<GenericResponse<Sale>> getSaleById(@PathVariable Long saleId) {
        Sale saleFound = null;
        try {
            saleFound = this.saleUseCase.getSaleById(saleId);
        } catch (SaleNotFoundException e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(e.getMessage(), null));
        }
        return ResponseEntity.ok(new GenericResponse<>("", saleFound));
    }

    @DeleteMapping(value = "/{saleId}")
    public ResponseEntity<GenericResponse<Boolean>> deleteSale(@PathVariable Long saleId) {

        try {
            this.saleUseCase.deleteSale(saleId);
        } catch (SaleNotFoundException e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(e.getMessage(), false));
        }
        return ResponseEntity.ok(new GenericResponse<>("sale deleted", true));
    }

    @PutMapping
    public ResponseEntity<GenericResponse<Sale>> updateSale(@RequestBody Sale sale) {
        Sale saleUpdated = null;
        try {
            saleUpdated = this.saleUseCase.updateSale(sale);
        } catch (SaleNotFoundException e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(e.getMessage(), null));
        }
        return ResponseEntity.ok(new GenericResponse<>("sale updated", saleUpdated));
    }
}
