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
<<<<<<< HEAD
    public Long addVisitor(@RequestBody Visitor visitor) {
        if (visitor.getFirstNameName() == null) {}
        return visitorService.addVisitor(visitor);
    }
}
=======
    public Long addProduct(@RequestBody Visitor visitor) {
        if (visitor.getName() == null) {}
        return visitorService.addVisitor(visitor);
    }
}

>>>>>>> 93a15a83e6c264b755899e100ae1e6d97f815c57
