package com.yetanotheruseless.industrycrashcourse.ecommerce.visitor;

import com.yetanotheruseless.industrycrashcourse.ecommerce.product.Product;

import javax.persistence.*;
<<<<<<< HEAD
import java.util.*;
=======
import java.util.List;
>>>>>>> 93a15a83e6c264b755899e100ae1e6d97f815c57


@Entity
@Table
public class Visitor {
    @Id
    @SequenceGenerator(name = "visitor_seq", sequenceName = "visitor_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "visitor_seq")
    private long id;
<<<<<<< HEAD
    private String firstName;
=======
    private String name;
>>>>>>> 93a15a83e6c264b755899e100ae1e6d97f815c57
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
<<<<<<< HEAD
        this.firstName = name;
=======
        this.name = name;
>>>>>>> 93a15a83e6c264b755899e100ae1e6d97f815c57
        this.surname = surname;
        this.lastVisitTimestamp = lastVisitTimestamp;
    }
    public Visitor(String name,
                   String surname,
                   String lastVisitTimestamp){
<<<<<<< HEAD
        this.firstName = name;
=======
        this.name = name;
>>>>>>> 93a15a83e6c264b755899e100ae1e6d97f815c57
        this.surname = surname;
        this.lastVisitTimestamp = lastVisitTimestamp;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

<<<<<<< HEAD
    public String getFirstNameName() {
        return firstName;
    }

    public void setFirstNameame(String firstName) { this.firstName = firstName; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }
=======
    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }

    public void setSurname(String name) { this.surname = surname; }
>>>>>>> 93a15a83e6c264b755899e100ae1e6d97f815c57

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
<<<<<<< HEAD
                "surname='" + surname + '\'' +
                ", firstName='" + firstName + '\'' +
=======
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
>>>>>>> 93a15a83e6c264b755899e100ae1e6d97f815c57
                ", id='" + id + '\'' +
                ", lastVisitTimestamp=" + lastVisitTimestamp +
                ", itemsInCart=" + itemsInCart +
                '}';
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 93a15a83e6c264b755899e100ae1e6d97f815c57
