package com.yetanotheruseless.industrycrashcourse.ecommerce.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductCLI {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            if (args.length > 0) {
                String path = args[0];
                int fileLimit = 1;
                if (args.length > 1) {
                    fileLimit = Integer.parseInt(args[1]);
                }
                /*
                for (List<Product> batch : ProductLoader.loadProductsForJava(path, fileLimit)) {
                    productRepository.saveAll(batch);
                }
                */
            }
        };
    }
}
