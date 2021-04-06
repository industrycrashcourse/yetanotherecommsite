package com.yetanotheruseless.industrycrashcourse.ecommerce.visitor;

import com.yetanotheruseless.industrycrashcourse.ecommerce.product.Product;

import javax.persistence.*;
import java.util.*;


@Entity
@Table
public class Visitor {
    @Id
    @SequenceGenerator(name = "visitor_seq", sequenceName = "visitor_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "visitor_seq")
    private long id;
    private String firstName;
    private String surname;
    private String lastVisitTimestamp;
    @ElementCollection
    private List<Product> itemsInCart;

    public Visitor() {}
    public Visitor(long id,
                   String name,
                   String surname,
                   String lastVisitTimestamp){
        this.id = id;
        this.firstName = name;
        this.surname = surname;
        this.lastVisitTimestamp = lastVisitTimestamp;
    }
    public Visitor(String name,
                   String surname,
                   String lastVisitTimestamp){
        this.firstName = name;
        this.surname = surname;
        this.lastVisitTimestamp = lastVisitTimestamp;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public void setlastVisitTimestamp (String lastvisitStamp) {
        this.lastVisitTimestamp = lastvisitStamp;
    }

    public String getLastVisitTimestamp(){return lastVisitTimestamp;}

    public List<Product> getItemsInCart() {
        return itemsInCart;
    }

    public void setItemsInCart(List<Product> itemsInCart) {
        this.itemsInCart = itemsInCart;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "surname='" + surname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", id='" + id + '\'' +
                ", lastVisitTimestamp=" + lastVisitTimestamp +
                ", itemsInCart=" + itemsInCart +
                '}';
    }
}