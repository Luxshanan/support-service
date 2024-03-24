package com.lcorp.supportservice.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String productName;

    @Column
    private String productDescription;

    @Column 
    private  Double price;

    @Column 
    private  Long supplierId;

    @Column 
    private  String sku;

    @Column 
    private  Integer stockQuantity;

    @Column
    private  String productImageUrl;

    @ManyToOne
    @JoinColumn(name="productCategoryId", nullable=false)
    private ProductCategory productCategory;
}
