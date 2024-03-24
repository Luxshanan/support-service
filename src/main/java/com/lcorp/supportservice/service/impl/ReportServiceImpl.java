package com.lcorp.supportservice.service.impl;

import com.lcorp.supportservice.model.dao.ProductSales;
import com.lcorp.supportservice.model.dao.SalesReport;
import com.lcorp.supportservice.model.entity.Cart;
import com.lcorp.supportservice.model.entity.CartItem;
import com.lcorp.supportservice.model.entity.Product;
import com.lcorp.supportservice.repository.CartRepository;
import com.lcorp.supportservice.repository.ProductRepository;
import com.lcorp.supportservice.service.ReportService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReportServiceImpl implements ReportService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public ReportServiceImpl(CartRepository cartRepository,
                             ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public SalesReport generateSalesReport() {
        List<Cart> cartList = cartRepository.findByCartStatus("Completed");
        Map<Long, Integer> productIdToSoldUnitsMap = new HashMap<>();
        for (Cart cart: cartList) {
            List<CartItem> cartItems = cart.getCartItems();
            for (CartItem cartItem : cartItems) {
                Product product = cartItem.getProduct();
                productIdToSoldUnitsMap.merge(product.getId(), cartItem.getQuantity(), Integer::sum);
            }
        }



        List<ProductSales> productSalesList = new ArrayList<>();
        productIdToSoldUnitsMap.forEach((productId, soldUnits) -> {
            Optional <Product> productOptional = productRepository.findById(productId);
            Product product = productOptional.get();
            ProductSales productSales = ProductSales.builder()
                    .productSku(product.getSku())
                    .productName(product.getProductName())
                    .unitPrice(product.getPrice())
                    .unitsSold(soldUnits)
                    .total(soldUnits * product.getPrice())
                    .build();
            productSalesList.add(productSales);
        });

        SalesReport salesReport = new SalesReport();
        salesReport.setProductSalesList(productSalesList);
        return salesReport;
    }
}
