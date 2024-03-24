package com.lcorp.supportservice.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long cartId;

    @ManyToOne
    @JoinColumn(name="productId", nullable=false)
    private Product product;

    @Column
    private Integer quantity;
}
