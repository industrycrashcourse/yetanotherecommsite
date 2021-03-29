package com.yetanotheruseless.industrycrashcourse.ecommerce.productReview;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class ProductReview {
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
