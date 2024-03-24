package com.lcorp.supportservice.repository;

import com.lcorp.supportservice.model.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Long> {
    List<Cart> findByCartStatus(String cartStatus);
}
