package com.lcorp.supportservice.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userId;

    @Column
    private String cartStatus;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name="cartId")
    private List<CartItem> cartItems;
}
