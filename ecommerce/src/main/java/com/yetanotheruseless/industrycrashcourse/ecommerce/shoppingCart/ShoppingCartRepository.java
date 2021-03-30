package com.yetanotheruseless.industrycrashcourse.ecommerce.shoppingCart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    Optional<ShoppingCart> findOneById(Long id);

    List<ShoppingCart> findAllByLastUpdatedAtTimestampBefore(LocalDateTime dateTime);

}
