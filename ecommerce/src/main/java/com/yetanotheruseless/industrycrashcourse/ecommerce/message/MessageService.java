package com.yetanotheruseless.industrycrashcourse.ecommerce.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Optional<Message> findByEmailAddress(String emailAddress) {
        return messageRepository.findOneByEmailAddress(emailAddress);
    }

    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    public List<Message> findByDateRange(Long earliest, Long latest) {
        return messageRepository.findAllByDateBetween(earliest, latest);
    }

    public Long addRecipient(Message recipient) {
        Message added = messageRepository.save(recipient);
        return added.getId();
    }

}
