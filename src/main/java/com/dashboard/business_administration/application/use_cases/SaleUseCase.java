package com.dashboard.business_administration.application.use_cases;

import com.dashboard.business_administration.domain.models.Sale;
import com.dashboard.business_administration.domain.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleUseCase {

    @Autowired private SaleRepository saleRepository;

    public Sale saveSale(Double price, String description, Integer quantities) {
        Sale saleToSave = new Sale(price, description, quantities);
        this.saleRepository.saveSale(saleToSave);
        return saleToSave;
    }
}
