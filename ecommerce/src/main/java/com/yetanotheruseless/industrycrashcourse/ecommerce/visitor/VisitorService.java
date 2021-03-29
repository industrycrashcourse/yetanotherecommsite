package com.yetanotheruseless.industrycrashcourse.ecommerce.visitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitorService {
    private final VisitorRepository visitorRepository;

    @Autowired
    public VisitorService(VisitorRepository visitorRepository) {this.visitorRepository = visitorRepository;}

    public Optional<Visitor> findById(Long id){return visitorRepository.findById(id);}

    public List<Visitor> findAll() { return visitorRepository.findAll();}

    public Long addVisitor(Visitor visitor){
        Visitor saved = visitorRepository.save(visitor);
        return saved.getId();
    }
}
