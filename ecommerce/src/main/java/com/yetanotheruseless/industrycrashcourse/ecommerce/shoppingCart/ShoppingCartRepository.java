package com.yetanotheruseless.industrycrashcourse.ecommerce.shoppingCart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    Optional<ShoppingCart> findOneById(Long id);

    // spring boot does not natively support this type of query, so we have to handwrite it.
    // convert java.time.Instant to a java.sql.Timestamp using Timestamp.from(Instant)
    @Query("select cart from ShoppingCart cart where cart.lastUpdatedAtTimestamp <= :instant")
    List<ShoppingCart> findAllWithLastUpdatedAtTimestampBefore(
            @Param("instant") Instant instant);

}
