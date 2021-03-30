package com.yetanotheruseless.industrycrashcourse.ecommerce.shoppingCart;

import com.yetanotheruseless.industrycrashcourse.ecommerce.product.Product;

import javax.persistence.*;

import java.time.*;

@Entity
@Table
public class ShoppingCart {

    @Id
    @SequenceGenerator(name = "shoppingcart_sequence", sequenceName = "shoppingcart_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shoppingcart_sequence")
    private Long id;
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
        numOfItemsInCart++;
    }

    public void removeProductFromCart(Product product) {
        numOfItemsInCart--;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                "lastUpdatedAtTimestamp=" + lastUpdatedAtTimestamp.toString() +
                "numOfItemsInCart=" + numOfItemsInCart +
                "isCanceled=" + isCanceled +
                "}";
    }
}