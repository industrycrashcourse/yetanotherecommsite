package com.yetanotheruseless.industrycrashcourse.ecommerce.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "all")
    public List<Product> list() {
        return productService.findAll();
    }

    @GetMapping(path = "{sku}")
    public Product get(@PathVariable String sku) {
        return productService.findBySku(sku).orElseThrow(() -> new RuntimeException("not found"));
    }

    @PostMapping
    public Long addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
}
