package com.yetanotheruseless.industrycrashcourse.ecommerce.visitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/visitor")

public class VisitorController {

    private final VisitorService visitorService;

    @Autowired
    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }


    @GetMapping(path = "list")
    public List<Visitor> list() {
        return visitorService.findAll();
    }

    @GetMapping(path = "{id}")
    public Visitor get(@PathVariable long id) {
        return visitorService.findById(id).orElseThrow(() -> new RuntimeException("Lamine did something wrong"));
    }

    @PostMapping
    public Long addVisitor(@RequestBody Visitor visitor) {
        if (visitor.getFirstName() == null) {System.out.println("Does Not Exist");}
        return visitorService.addVisitor(visitor);
    }
}