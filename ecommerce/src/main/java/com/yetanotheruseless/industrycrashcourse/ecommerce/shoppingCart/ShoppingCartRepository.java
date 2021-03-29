package com.yetanotheruseless.industrycrashcourse.ecommerce.shoppingCart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    Optional<ShoppingCart> findOneBySku(String sku);

    List<ShoppingCart> findAllCreatedBeforeDate(LocalDateTime dateTime);

}
