package com.yetanotheruseless.industrycrashcourse.ecommerce.event;

public class EventService {
    public class EventService {

        private final EventRepository EventRepository;

        @Autowired
        public EventService(EventRepository eventRepository) {
            this.eventRepository = eventRepository;
        }

        public Optional<eventRepository> findBySku(String sku) {
            return eventRepository.findOneBySku(sku);
        }

        public List<EventRepository> findAll() {
            return eventRepository.findAll();
        }

        public List<EventCart> findTime(LocalDateTime dateTime) {
            return eventRepository.findTime(dateTime);
        }

        public Long addEvent(Event event) {
            Event saved = eventRepository.save(event);
            return saved.getId();
        }

    }
}