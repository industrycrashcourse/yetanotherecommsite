package com.yetanotheruseless.industrycrashcourse.ecommerce.productReview;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/productReview")
public class ProductReviewController {

    private final ProductReviewService productReviewService;

    public ProductReviewController(ProductReviewService productReviewService) {
        this.productReviewService = productReviewService;
    }

    @GetMapping(path = "all")
    public List<ProductReview> list() {
        return productReviewService.findAll();
    }

    @PostMapping
    public Long addReview(@RequestBody ProductReview review) {
        return productReviewService.addReview(review);
    }
}
