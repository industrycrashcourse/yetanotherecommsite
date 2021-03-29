package com.yetanotheruseless.industrycrashcourse.ecommerce.shoppingCart;

import com.yetanotheruseless.industrycrashcourse.ecommerce.product.Product;

import javax.persistence.*;

import java.time.*;

@Entity
@Table
public class ShoppingCart {

    @Id
    private Long id;
    private String sku;
    private int numOfItemsInCart;
    private LocalDateTime lastUpdatedAtTimestamp;
    private boolean isCanceled = false;

    public ShoppingCart() {
        lastUpdatedAtTimestamp = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getNumOfItemsInCart() {
        return numOfItemsInCart;
    }

    public void setNumOfItemsInCart(int numOfItemsInCart) {
        this.numOfItemsInCart = numOfItemsInCart;
    }

    public LocalDateTime getLastUpdatedAtTimestamp() {
        return lastUpdatedAtTimestamp;
    }

    public void setLastUpdatedAtTimestamp(LocalDateTime lastUpdatedAtTimestamp) {
        this.lastUpdatedAtTimestamp = lastUpdatedAtTimestamp;
    }

    public boolean getIsCanceled() {
        return isCanceled;
    }

    public void setIsCanceled(boolean isCanceled) {
        this.isCanceled = isCanceled;
    }

    public void addProductToCart(Product product) {
//        productsInCart.add(product);
        numOfItemsInCart++;
    }
}