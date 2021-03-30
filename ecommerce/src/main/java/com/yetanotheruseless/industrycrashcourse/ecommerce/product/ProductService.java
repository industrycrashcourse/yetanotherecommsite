package com.yetanotheruseless.industrycrashcourse.ecommerce.product;

import com.yetanotheruseless.industrycrashcourse.ecommerce.Order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> findBySku(String sku) {
        return productRepository.findOneBySku(sku);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findByCustomerReviewAverageRange(Double min, Double max) {
        return productRepository.findAllByCustomerReviewAverageBetween(min, max);
    }

    public Long addProduct(Product product) {
        Product saved = productRepository.save(product);
        return saved.getId();
    }

    public List<Order> findByOrderid(Double id) {
        return productRepository.findByOrderId(id);
    }
}
