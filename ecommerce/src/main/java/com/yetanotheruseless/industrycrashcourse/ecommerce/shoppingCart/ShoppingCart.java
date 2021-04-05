package com.yetanotheruseless.industrycrashcourse.ecommerce.shoppingCart;

import com.yetanotheruseless.industrycrashcourse.ecommerce.product.Product;

import javax.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class ShoppingCart {

    @Id
    @SequenceGenerator(name = "shoppingcart_sequence", sequenceName = "shoppingcart_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shoppingcart_sequence")
    private Long id;
    private int numOfItemsInCart;
    private Instant lastUpdatedAtTimestamp;
    private boolean isCanceled = false;
    @ManyToMany
    private List<Product> productsInCart;

    public ShoppingCart() {
        productsInCart = new ArrayList<>();
        numOfItemsInCart = 0;
        lastUpdatedAtTimestamp = Instant.now();
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

    public Instant getLastUpdatedAtTimestamp() {
        return lastUpdatedAtTimestamp;
    }

    public void setLastUpdatedAtTimestamp(Instant lastUpdatedAtTimestamp) {
        this.lastUpdatedAtTimestamp = lastUpdatedAtTimestamp;
    }

    public boolean getIsCanceled() {
        return isCanceled;
    }

    public void setIsCanceled(boolean isCanceled) {
        this.isCanceled = isCanceled;
    }

    public List<Product> getProductsInCart() {
        return productsInCart;
    }

    public void setProductsInCart(List<Product> productsInCart) {
        this.productsInCart = productsInCart;
    }

    public void addProductToCart(Product product) {
        productsInCart.add(product);
        numOfItemsInCart = productsInCart.size();
        lastUpdatedAtTimestamp = Instant.now();
    }

    public void removeProductFromCart(Product product) {
        if(productsInCart.remove(product)) {
            lastUpdatedAtTimestamp = Instant.now();
        }
        numOfItemsInCart = productsInCart.size();
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", lastUpdatedAtTimestamp=" + lastUpdatedAtTimestamp.toString() +
                ", numOfItemsInCart=" + numOfItemsInCart +
                ", isCanceled=" + isCanceled +
                ", productsInCart=" + productsInCart +
                "}";
    }
}