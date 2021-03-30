package com.yetanotheruseless.industrycrashcourse.ecommerce.shoppingCart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/shoppingCart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping(path = "list")
    public List<ShoppingCart> list() {
        return shoppingCartService.findAll();
    }

    @GetMapping(path = "{id}")
    public ShoppingCart get(@PathVariable Long id) {
        return shoppingCartService.findById(id).orElseThrow(() -> new RuntimeException("Shopping cart not found. Id: " + id));
    }

    @PostMapping
    public Long addShoppingCart(@RequestBody ShoppingCart shoppingCart) {
//        if (shoppingCart.getName() == null) {
//            // shopping cart does not have name qualifier... yet
//        }
        return shoppingCartService.addShoppingCart(shoppingCart);
    }

    // retrieves all shopping carts created before a certain date. useful for
    // emailing users about carts that have been sitting for more than a day
    // or other related issues.
    @GetMapping(path = "createdBeforeDate/{dateTime}")
    public List<ShoppingCart> lastUpdatedAtTimestampBefore(@PathVariable LocalDateTime dateTime) {
        return shoppingCartService.findByLastUpdatedAtTimestampBefore(dateTime);
    }
}