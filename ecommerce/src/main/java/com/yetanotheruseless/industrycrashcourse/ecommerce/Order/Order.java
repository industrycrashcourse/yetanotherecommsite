package com.yetanotheruseless.industrycrashcourse.ecommerce.Order;

import javax.persistence.*;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
//@Getter
//@Setter
//@NoArgsConstructor
//@ToString

public class Order {

    @Id
    @SequenceGenerator(name = "order_sequence", sequenceName = "order_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence")
    private Long id;
    private String sku;
    private String name;
    private String type;
    private Double regularPrice;


    public Order() {}

    public Order(Long id,
                 String sku,
                 String name,
                 String type,
                 Double regularPrice) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.type = type;
        this.regularPrice = regularPrice;
    }

    public Order(String sku,
                 String name,
                 String type,
                 Double regularPrice) {
        this.sku = sku;
        this.name = name;
        this.type = type;
        this.regularPrice = regularPrice;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(Double regularPrice) {
        this.regularPrice = regularPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", regularPrice=" + regularPrice +
                '}';
    }
}
