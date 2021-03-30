package com.yetanotheruseless.industrycrashcourse.ecommerce.shoppingCart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public Optional<ShoppingCart> findById(Long id) {
        return shoppingCartRepository.findOneById(id);
    }

    public List<ShoppingCart> findAll() {
        return shoppingCartRepository.findAll();
    }

    public List<ShoppingCart> findByLastUpdatedAtTimestampBefore(LocalDateTime dateTime) {
        return shoppingCartRepository.findAllByLastUpdatedAtTimestampBefore(dateTime);
    }

    public Long addShoppingCart(ShoppingCart shoppingCart) {
        ShoppingCart saved = shoppingCartRepository.save(shoppingCart);
        return saved.getId();
    }

}