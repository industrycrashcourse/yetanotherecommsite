package com.yetanotheruseless.industrycrashcourse.ecommerce.event;



import javax.persistence.*;
import java.time.*;

@Entity
@Table

public class Event {
    public Long getId() {
        return id;
}

    public void setId(Long id) {
        this.id = id;
    }
    @Id
    private Long id;
    private String eventType;
    private String sku;
    private LocalDateTime lastUpdatedAtTimestamp;
    private int numEvents;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long geteventType() {
        return eventType;
    }

    public void setId(Long eventType) {
        this.eventType = eventType;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public LocalDateTime getLastUpdatedAtTimestamp() {
        return lastUpdatedAtTimestamp;
    }

    public void setLastUpdatedAtTimestamp(LocalDateTime lastUpdatedAtTimestamp) {
        this.lastUpdatedAtTimestamp = lastUpdatedAtTimestamp;
    }
    public void addEvent(Event event) {

        numEvents++;
    }

    public Event(Long id, String eventType, LocalDateTime lastUpdatedAtTimestamp){
        this.id = id;
        this.eventType = eventType;
        this.lastUpdatedAtTimestamp = lastUpdatedAtTimestamp;
    }
}
