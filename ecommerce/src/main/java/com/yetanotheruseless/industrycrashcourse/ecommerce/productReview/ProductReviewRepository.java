package com.yetanotheruseless.industrycrashcourse.ecommerce.productReview;

import com.yetanotheruseless.industrycrashcourse.ecommerce.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductReviewRepository extends JpaRepository<ProductReview, Long> {
    Optional<ProductReview> findOneByCustomerId(Long customerId);
}
