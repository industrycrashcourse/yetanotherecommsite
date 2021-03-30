package com.yetanotheruseless.industrycrashcourse.ecommerce.product;

import com.yetanotheruseless.industrycrashcourse.ecommerce.Order.Order;
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

    @GetMapping(path = "list")
    public List<Product> list() {
        return productService.findAll();
    }

    @GetMapping(path = "{sku}")
    public Product get(@PathVariable String sku) {
        return productService.findBySku(sku).orElseThrow(() -> new RuntimeException("dude, not found"));
    }

    @PostMapping
    public Long addProduct(@RequestBody Product product) {
        if (product.getName() == null) {
            // no way!  throw exception
        }
        return productService.addProduct(product);
    }


    @GetMapping(path = "byCustomerReviewAverage/{min}/{max}")
    public List<Product> byCustomerReviewAverage(@PathVariable Double min, @PathVariable Double max) {
        return productService.findByCustomerReviewAverageRange(min, max);
    }

    @GetMapping(path = "byOrderId/{Id}")
    public List<Order> byOrderId(@PathVariable Double Id) {
        return productService.findByOrderid(Id);
    }
}
