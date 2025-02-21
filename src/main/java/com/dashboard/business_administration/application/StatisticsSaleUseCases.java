package com.dashboard.business_administration.application;

import com.dashboard.business_administration.domain.models.Sale;
import com.dashboard.business_administration.domain.repositories.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsSaleUseCases {

    @Autowired private StatisticsRepository repository;

    public Double getSaleTotal() {
        return this.repository.saleTotal();
    }

    public List<Sale> getSalesLessThan(Double value) {
        return this.repository.salesLessThan(value);
    }
}
