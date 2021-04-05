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

<<<<<<< HEAD
    public Optional<Visitor> findById(Long id){return visitorRepository.findOneById(id);}
=======
    public Optional<Visitor> findById(Long id){return visitorRepository.findById(id);}
>>>>>>> 93a15a83e6c264b755899e100ae1e6d97f815c57

    public List<Visitor> findAll() { return visitorRepository.findAll();}

    public Long addVisitor(Visitor visitor){
        Visitor saved = visitorRepository.save(visitor);
        return saved.getId();
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 93a15a83e6c264b755899e100ae1e6d97f815c57
