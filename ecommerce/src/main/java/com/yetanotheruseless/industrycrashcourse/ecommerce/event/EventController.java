package com.yetanotheruseless.industrycrashcourse.ecommerce.event;

import com.yetanotheruseless.industrycrashcourse.ecommerce.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/event")

public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService EventService) {
        this.EventService = EventService;
    }

    @GetMapping(path = "list")
    public List<Event> list() {
        return EventService.findAll();
    }

    @GetMapping(path = "list")
    public List<Event> list() {
        return EventService.findAll();
    }
    @GetMapping(path = "byEventType/{EventType}")
    public Event get(@PathVariable String eventType) {
        return EventService.findByEventType(eventType).orElseThrow(() -> new RuntimeException("shit"));
    }

    @PostMapping
    public Long addRecipient(@RequestBody Event event) {
        if (event.geteventType() == null) {
        }
    }