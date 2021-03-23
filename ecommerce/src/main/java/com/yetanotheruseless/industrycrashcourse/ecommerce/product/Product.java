package com.yetanotheruseless.industrycrashcourse.ecommerce.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {
    @Id
    @SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    private Long id;
    private String sku;
    private String name;
    private String type;
    private Double regularPrice;
    private String image;
    private String mediumImage;
    private String thumbnailImage;
    private String shortDescription;
    private String longDescription;
    private Integer salesRankShortTerm;
    private Integer salesRankMediumTerm;
    private Integer salesRankLongTerm;
    private Integer customerReviewCount;
    private Double customerReviewAverage;
    @ElementCollection
    private List<String> frequentlyPurchasedWith;

    public Product(Long id,
                   String sku,
                   String name,
                   String type,
                   Double regularPrice,
                   String image,
                   String mediumImage,
                   String thumbnailImage,
                   String shortDescription,
                   String longDescription,
                   Integer salesRankShortTerm,
                   Integer salesRankMediumTerm,
                   Integer salesRankLongTerm,
                   Integer customerReviewCount,
                   Double customerReviewAverage,
                   List<String> frequentlyPurchasedWith) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.type = type;
        this.regularPrice = regularPrice;
        this.image = image;
        this.mediumImage = mediumImage;
        this.thumbnailImage = thumbnailImage;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.salesRankShortTerm = salesRankShortTerm;
        this.salesRankMediumTerm = salesRankMediumTerm;
        this.salesRankLongTerm = salesRankLongTerm;
        this.customerReviewCount = customerReviewCount;
        this.customerReviewAverage = customerReviewAverage;
        this.frequentlyPurchasedWith = frequentlyPurchasedWith;
    }

    public Product(String sku,
                   String name,
                   String type,
                   Double regularPrice,
                   String image,
                   String mediumImage,
                   String thumbnailImage,
                   String shortDescription,
                   String longDescription,
                   Integer salesRankShortTerm,
                   Integer salesRankMediumTerm,
                   Integer salesRankLongTerm,
                   Integer customerReviewCount,
                   Double customerReviewAverage,
                   List<String> frequentlyPurchasedWith) {
        this.sku = sku;
        this.name = name;
        this.type = type;
        this.regularPrice = regularPrice;
        this.image = image;
        this.mediumImage = mediumImage;
        this.thumbnailImage = thumbnailImage;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.salesRankShortTerm = salesRankShortTerm;
        this.salesRankMediumTerm = salesRankMediumTerm;
        this.salesRankLongTerm = salesRankLongTerm;
        this.customerReviewCount = customerReviewCount;
        this.customerReviewAverage = customerReviewAverage;
        this.frequentlyPurchasedWith = frequentlyPurchasedWith;
    }
}
