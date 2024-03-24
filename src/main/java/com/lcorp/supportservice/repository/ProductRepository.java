package com.lcorp.supportservice.repository;

import com.lcorp.supportservice.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

   Optional<Product> findById(Long productId);
}
