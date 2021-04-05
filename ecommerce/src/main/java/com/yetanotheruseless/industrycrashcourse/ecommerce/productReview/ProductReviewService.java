package com.yetanotheruseless.industrycrashcourse.ecommerce.productReview;

import com.yetanotheruseless.industrycrashcourse.ecommerce.product.Product;

import com.yetanotheruseless.industrycrashcourse.ecommerce.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductReviewService {
    private final ProductReviewService productReviewRepository;

    @Autowired
    public ProductReviewService(ProductReviewRepository productReviewRepository) {
        this.productReviewRepository = (ProductReviewService) productReviewRepository;
    }

    public Optional<ProductReview> findByCustomerId(Long customerId) {
        return productReviewRepository.findOneByCustomerId(customerId);
    }

    private Optional<ProductReview> findOneByCustomerId(Long customerId) { return productReviewRepository.findOneByCustomerId(customerId);
    }

    public List<ProductReview> findAll() {
        return productReviewRepository.findAll();
    }

    public Long addReview(ProductReview review) {
        ProductReview saved = productReviewRepository.save(review);
        return saved.getId();
    }
}
