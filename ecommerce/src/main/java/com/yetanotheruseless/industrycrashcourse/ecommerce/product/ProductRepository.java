package com.yetanotheruseless.industrycrashcourse.ecommerce.product;

import com.yetanotheruseless.industrycrashcourse.ecommerce.Order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findOneBySku(String sku);

    List<Product> findAllByCustomerReviewAverageBetween(Double min, Double max);

    List<Order> findByOrderId(Double id);

}
