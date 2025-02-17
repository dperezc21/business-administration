package com.dashboard.business_administration.infrastructure;

import com.dashboard.business_administration.domain.models.Sale;
import com.dashboard.business_administration.domain.repositories.SaleRepository;
import com.dashboard.business_administration.infrastructure.database.MysqlSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SaleImplementationRepository implements SaleRepository {

    @Autowired private MysqlSaleRepository repository;

    @Override
    public void saveSale(Sale sale) {
        this.repository.save(sale);
    }

    @Override
    public void updateSale(Sale sale) {
        this.saveSale(sale);
    }

    @Override
    public void deleteSale(Long saleId) {
        this.repository.deleteById(saleId);
    }

    @Override
    public Sale getSaleById(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public List<Sale> getAllSales() {
        return (List<Sale>) this.repository.findAll();
    }
}
