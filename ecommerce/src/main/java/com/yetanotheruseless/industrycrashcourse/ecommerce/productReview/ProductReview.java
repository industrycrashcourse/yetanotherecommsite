package com.yetanotheruseless.industrycrashcourse.ecommerce.productReview;
import com.yetanotheruseless.industrycrashcourse.ecommerce.product.Product;
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
public class ProductReview {
    @SequenceGenerator(name = "productReview_sequence", sequenceName = "ProductReview_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProductReview_sequence")
    private Long id;
    private Long customerId;
    private double productRating; //Can be a number 1-5
    private String review;

    public ProductReview() {}

    public ProductReview(Long id, Long customerId, double productRating, String review){
        this.id = id;
        this.customerId = customerId;
        this.productRating = productRating;
        this.review = review;

    }

    @Id
    public Long getId() { return id; }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId){ this.customerId = customerId;}

    public double geProductRating() { return productRating; }
    public void setProductRating(double productRating){ this.productRating = productRating;}

    public String getReview() {return review; }
    public void setReview(String review){ this.review = review;}

}
