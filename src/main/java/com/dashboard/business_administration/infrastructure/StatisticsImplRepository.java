package com.dashboard.business_administration.infrastructure;


import com.dashboard.business_administration.domain.models.Sale;
import com.dashboard.business_administration.domain.repositories.StatisticsRepository;
import com.dashboard.business_administration.infrastructure.database.MysqlSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StatisticsImplRepository implements StatisticsRepository {

    @Autowired
    private MysqlSaleRepository repository;

    @Override
    public Double saleTotal() {
        return this.repository.saleTotal();
    }

    @Override
    public List<Sale> salesLessThan(Double aDouble) {
        return List.of();
    }
}
