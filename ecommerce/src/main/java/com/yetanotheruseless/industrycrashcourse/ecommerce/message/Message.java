package com.yetanotheruseless.industrycrashcourse.ecommerce.message;

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

public class Message {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @SequenceGenerator(name = "message_sequence", sequenceName = "message_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_sequence")
    private Long id;
    private Long orderConfirmationNumber;
    private String recipientEmailAddress;
    private String recipientFirstName;
    private String recipientLastName;
    private String recipientMailingAddress;
    private String senderEmailAddress;
    private String senderCompanyName;
    private String senderMailingAddress;
    private String supportEmailAddress;
    private String messageBody;
    private String messageSubject;
    private String sku;
    private String productName;
    private Double price;
    private String thumbnailImage;
    private String shortDescription;
    private String shippingTimeEstimate;
    private String headers;
    private String feedbackLink;

    @ElementCollection
    private List<String> frequentlyPurchasedWith;

    public Message(Long id, Long orderConfirmationNumber, String recipientEmailAddress, String recipientFirstName, String recipientLastName, String recipientMailingAddress, String senderEmailAddress, String senderCompanyName, String senderMailingAddress, String supportEmailAddress, String messageBody, String messageSubject, String sku, String productName, Double price, String thumbnailImage, String shortDescription, String shippingTimeEstimate, String headers, String feedbackLink, List<String> frequentlyPurchasedWith) {
        this.id = id;
        this.orderConfirmationNumber = orderConfirmationNumber;
        this.recipientEmailAddress = recipientEmailAddress;
        this.recipientFirstName = recipientFirstName;
        this.recipientLastName = recipientLastName;
        this.recipientMailingAddress = recipientMailingAddress;
        this.senderEmailAddress = senderEmailAddress;
        this.senderCompanyName = senderCompanyName;
        this.senderMailingAddress = senderMailingAddress;
        this.supportEmailAddress = supportEmailAddress;
        this.messageBody = messageBody;
        this.messageSubject = messageSubject;
        this.sku = sku;
        this.productName = productName;
        this.price = price;
        this.thumbnailImage = thumbnailImage;
        this.shortDescription = shortDescription;
        this.shippingTimeEstimate = shippingTimeEstimate;
        this.headers = headers;
        this.feedbackLink = feedbackLink;
        this.frequentlyPurchasedWith = frequentlyPurchasedWith;
    }

    public Message() {}
    public void setOrderConfirmationNumber(Long orderConfirmationNumber) {
        this.orderConfirmationNumber = orderConfirmationNumber;
    }

    public String getRecipientEmailAddress() {
        return recipientEmailAddress;
    }

    public void setRecipientEmailAddress(String recipientEmailAddress) {
        this.recipientEmailAddress = recipientEmailAddress;
    }

    public String getRecipientFirstName() {
        return recipientFirstName;
    }

    public void setRecipientFirstName(String recipientFirstName) {
        this.recipientFirstName = recipientFirstName;
    }

    public String getRecipientLastName() {
        return recipientLastName;
    }

    public void setRecipientLastName(String recipientLastName) {
        this.recipientLastName = recipientLastName;
    }

    public String getRecipientMailingAddress() {
        return recipientMailingAddress;
    }

    public void setRecipientMailingAddress(String recipientMailingAddress) {
        this.recipientMailingAddress = recipientMailingAddress;
    }

    public String getSenderEmailAddress() {
        return senderEmailAddress;
    }

    public void setSenderEmailAddress(String senderEmailAddress) {
        this.senderEmailAddress = senderEmailAddress;
    }

    public String getSenderCompanyName() {
        return senderCompanyName;
    }

    public void setSenderCompanyName(String senderCompanyName) {
        this.senderCompanyName = senderCompanyName;
    }

    public String getSenderMailingAddress() {
        return senderMailingAddress;
    }

    public void setSenderMailingAddress(String senderMailingAddress) {
        this.senderMailingAddress = senderMailingAddress;
    }

    public String getSupportEmailAddress() {
        return supportEmailAddress;
    }

    public void setSupportEmailAddress(String supportEmailAddress) {
        this.supportEmailAddress = supportEmailAddress;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getMessageSubject() {
        return messageSubject;
    }

    public void setMessageSubject(String messageSubject) {
        this.messageSubject = messageSubject;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public List<String> getFrequentlyPurchasedWith() {
        return frequentlyPurchasedWith;
    }

    public void setFrequentlyPurchasedWith(List<String> frequentlyPurchasedWith) {
        this.frequentlyPurchasedWith = frequentlyPurchasedWith;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getShippingTimeEstimate() {
        return shippingTimeEstimate;
    }

    public void setShippingTimeEstimate(String shippingTimeEstimate) {
        this.shippingTimeEstimate = shippingTimeEstimate;
    }
    public String getFeedbackLink() {
        return feedbackLink;
    }

    public void setFeedbackLink(String feedbackLink) {
        this.feedbackLink = feedbackLink;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", orderConfirmationNumber=" + orderConfirmationNumber +
                ", recipientEmailAddress='" + recipientEmailAddress + '\'' +
                ", recipientFirstName='" + recipientFirstName + '\'' +
                ", recipientLastName='" + recipientLastName + '\'' +
                ", recipientMailingAddress='" + recipientMailingAddress + '\'' +
                ", senderEmailAddress='" + senderEmailAddress + '\'' +
                ", senderCompanyName='" + senderCompanyName + '\'' +
                ", senderMailingAddress='" + senderMailingAddress + '\'' +
                ", supportEmailAddress='" + supportEmailAddress + '\'' +
                ", messageBody='" + messageBody + '\'' +
                ", messageSubject='" + messageSubject + '\'' +
                ", sku='" + sku + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", thumbnailImage='" + thumbnailImage + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", shippingTimeEstimate='" + shippingTimeEstimate + '\'' +
                ", headers='" + headers + '\'' +
                ", feedbackLink='" + feedbackLink + '\'' +
                ", frequentlyPurchasedWith=" + frequentlyPurchasedWith +
                '}';
    }
}
