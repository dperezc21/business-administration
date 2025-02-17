package com.dashboard.business_administration.domain.repositories;

import com.dashboard.business_administration.domain.models.Sale;

import java.util.List;

public interface SaleRepository {
    void saveSale(Sale sale);
    void updateSale(Sale sale);
    void deleteSale(Long saleId);
    Sale getSaleById(Long id);
    List<Sale> getAllSales();
}
