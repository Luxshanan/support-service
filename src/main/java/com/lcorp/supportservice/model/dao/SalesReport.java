package com.lcorp.supportservice.model.dao;

import lombok.Data;

import java.util.List;

@Data
public class SalesReport {
    List<ProductSales> productSalesList;
}
