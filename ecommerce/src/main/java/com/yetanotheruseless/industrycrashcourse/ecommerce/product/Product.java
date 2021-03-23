package com.yetanotheruseless.industrycrashcourse.ecommerce.product;

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

    public Product() {}

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMediumImage() {
        return mediumImage;
    }

    public void setMediumImage(String mediumImage) {
        this.mediumImage = mediumImage;
    }

    public String getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public Integer getSalesRankShortTerm() {
        return salesRankShortTerm;
    }

    public void setSalesRankShortTerm(Integer salesRankShortTerm) {
        this.salesRankShortTerm = salesRankShortTerm;
    }

    public Integer getSalesRankMediumTerm() {
        return salesRankMediumTerm;
    }

    public void setSalesRankMediumTerm(Integer salesRankMediumTerm) {
        this.salesRankMediumTerm = salesRankMediumTerm;
    }

    public Integer getSalesRankLongTerm() {
        return salesRankLongTerm;
    }

    public void setSalesRankLongTerm(Integer salesRankLongTerm) {
        this.salesRankLongTerm = salesRankLongTerm;
    }

    public Integer getCustomerReviewCount() {
        return customerReviewCount;
    }

    public void setCustomerReviewCount(Integer customerReviewCount) {
        this.customerReviewCount = customerReviewCount;
    }

    public Double getCustomerReviewAverage() {
        return customerReviewAverage;
    }

    public void setCustomerReviewAverage(Double customerReviewAverage) {
        this.customerReviewAverage = customerReviewAverage;
    }

    public List<String> getFrequentlyPurchasedWith() {
        return frequentlyPurchasedWith;
    }

    public void setFrequentlyPurchasedWith(List<String> frequentlyPurchasedWith) {
        this.frequentlyPurchasedWith = frequentlyPurchasedWith;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", regularPrice=" + regularPrice +
                ", image='" + image + '\'' +
                ", mediumImage='" + mediumImage + '\'' +
                ", thumbnailImage='" + thumbnailImage + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", salesRankShortTerm=" + salesRankShortTerm +
                ", salesRankMediumTerm=" + salesRankMediumTerm +
                ", salesRankLongTerm=" + salesRankLongTerm +
                ", customerReviewCount=" + customerReviewCount +
                ", customerReviewAverage=" + customerReviewAverage +
                ", frequentlyPurchasedWith=" + frequentlyPurchasedWith +
                '}';
    }
}
