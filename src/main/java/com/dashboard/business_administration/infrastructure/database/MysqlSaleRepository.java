package com.dashboard.business_administration.infrastructure.database;

import com.dashboard.business_administration.domain.models.Sale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MysqlSaleRepository extends CrudRepository<Sale, Long> {
    @Query("select sum(s.price) from Sale s")
    Double saleTotal();
}
