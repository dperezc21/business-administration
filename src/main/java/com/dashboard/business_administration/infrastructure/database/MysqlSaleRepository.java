package com.dashboard.business_administration.infrastructure.database;

import com.dashboard.business_administration.domain.models.Sale;
import org.springframework.data.repository.CrudRepository;

public interface MysqlSaleRepository extends CrudRepository<Sale, Long> { }
