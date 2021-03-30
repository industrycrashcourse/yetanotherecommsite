package com.yetanotheruseless.industrycrashcourse.ecommerce.visitor;

import com.yetanotheruseless.industrycrashcourse.ecommerce.product.Product;

import javax.persistence.*;
import java.util.List;


@Entity
@Table
public class Visitor {
    @Id
    @SequenceGenerator(name = "visitor_seq", sequenceName = "visitor_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "visitor_seq")
    private long id;
    private String name;
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
        this.name = name;
        this.surname = surname;
        this.lastVisitTimestamp = lastVisitTimestamp;
    }
    public Visitor(String name,
                   String surname,
                   String lastVisitTimestamp){
        this.name = name;
        this.surname = surname;
        this.lastVisitTimestamp = lastVisitTimestamp;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }

    public void setSurname(String name) { this.surname = surname; }

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
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", lastVisitTimestamp=" + lastVisitTimestamp +
                ", itemsInCart=" + itemsInCart +
                '}';
    }
}
