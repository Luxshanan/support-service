package com.lcorp.supportservice.model.dao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductSales {
    private String productSku;
    private String productName;
    private Double unitPrice;
    private Integer unitsSold;
    private Double total;
}
