package com.yetanotheruseless.industrycrashcourse.ecommerce.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/message")

public class MessageController {

        private final MessageService messageService;

        @Autowired
        public MessageController(MessageService messageService) {
            this.messageService = messageService;
        }

        @GetMapping(path = "list")
        public List<Message> list() {
            return messageService.findAll();
        }

        @GetMapping(path = "byEmail/{emailAddress}")
        public Message get(@PathVariable String emailAddress) {
            return messageService.findByEmailAddress(emailAddress).orElseThrow(() -> new RuntimeException("dood, whereabouts not established"));
        }

        @PostMapping
        public Long addRecipient(@RequestBody Message message) {
            if (message.getRecipientEmailAddress() == null) {
                // no way!  throw exception
            } else if(!message.getRecipientEmailAddress().contains("@")) { // more validation here. could use https://javaee.github.io/javamail/
                // no way! throw exception
            }
            return messageService.addRecipient(message);
        }


        @GetMapping(path = "byDate/{earliest}/{latest}") //format: MMDDYYYY
        public List<Message> byDate(@PathVariable Long earliest, @PathVariable Long latest) {
            return messageService.findByDateRange(earliest, latest);
        }
}
