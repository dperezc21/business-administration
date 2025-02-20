package com.dashboard.business_administration.domain.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SaleResponse {
    private Long saleId;
    private String description;
    private Double price;
    private Integer quantities;
    private Long categoryId;
}
