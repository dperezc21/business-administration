package com.dashboard.business_administration.infrastructure.database;

import com.dashboard.business_administration.domain.models.Sale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MysqlSaleRepository extends CrudRepository<Sale, Long> {
    @Query("select sum(s.price) from Sale s")
    Double saleTotal();

    @Query("select s from Sale s where s.price <= ?1")
    List<Sale> getSalesLessThan(Double value);
}
