package com.dashboard.business_administration.infrastructure.controllers;

import com.dashboard.business_administration.application.StatisticsSaleUseCases;
import com.dashboard.business_administration.domain.models.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(path = "/statistics")
public class StatisticsSaleController {

    @Autowired private StatisticsSaleUseCases statisticsSaleUseCases;

    @GetMapping("/total")
    public ResponseEntity<Double> salesTotal() {
        return ResponseEntity.ok(this.statisticsSaleUseCases.getSaleTotal());
    }

    @GetMapping("/less")
    public ResponseEntity<List<Sale>> salesLessThan(@RequestParam Double price) {
        return ResponseEntity.ok(this.statisticsSaleUseCases.getSalesLessThan(price));
    }
}
