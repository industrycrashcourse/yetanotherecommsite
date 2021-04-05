package com.yetanotheruseless.industrycrashcourse.ecommerce.visitor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor,Long>{
    Optional<Visitor> findOneById(long id);
<<<<<<< HEAD
}
=======
}
>>>>>>> 93a15a83e6c264b755899e100ae1e6d97f815c57
