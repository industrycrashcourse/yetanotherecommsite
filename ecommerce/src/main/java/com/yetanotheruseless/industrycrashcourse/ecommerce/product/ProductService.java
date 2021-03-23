package com.yetanotheruseless.industrycrashcourse.ecommerce.product;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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

    public Long addProduct(Product product) {
        Product saved = productRepository.save(product);
        return saved.getId();
    }

    public List<Product> list() {
        return Arrays.asList(
                new Product(
                        1L,
                        "2570",
                        "Fuji - 110 Color Print Disc Film (24 exposures)",
                        "HardGood",
                        1.89,
                        "http://images.bestbuy.com/BestBuy_US/images/products/2570/2570_rc.jpg",
                        "http://images.bestbuy.com/BestBuy_US/images/products/2570/2570fp.gif",
                        "http://images.bestbuy.com/BestBuy_US/images/products/2570/2570_r.gif",
                        "110 disc color print, 200-speed film; 24 exposures; for use indoors with flash or outdoors",
                        "110 disc color print, 200-speed film. 24 exposures. For use indoors with flash or outdoors.",
                        null,
                        null,
                        null,
                        null,
                        null,
                        Lists.emptyList()
                )
        );
    }
}
