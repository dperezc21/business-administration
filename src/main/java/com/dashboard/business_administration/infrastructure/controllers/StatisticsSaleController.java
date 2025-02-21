package com.dashboard.business_administration.infrastructure.controllers;

import com.dashboard.business_administration.application.StatisticsSaleUseCases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/statistics")
public class StatisticsSaleController {

    @Autowired private StatisticsSaleUseCases statisticsSaleUseCases;

    @GetMapping("/category")
    public ResponseEntity<Double> salesTotal() {
        return ResponseEntity.ok(this.statisticsSaleUseCases.getSaleTotal());
    }
}
