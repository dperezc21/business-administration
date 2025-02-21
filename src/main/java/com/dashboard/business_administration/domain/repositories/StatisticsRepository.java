package com.dashboard.business_administration.domain.repositories;

import com.dashboard.business_administration.domain.models.Sale;

import java.util.List;

public interface StatisticsRepository {
    Double saleTotal();
    List<Sale> salesLessThan(Double aDouble);
}
