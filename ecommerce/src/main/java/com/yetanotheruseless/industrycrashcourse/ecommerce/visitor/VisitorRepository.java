package com.yetanotheruseless.industrycrashcourse.ecommerce.visitor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor,Long>{
    Optional<Visitor> findOneById(long id);
}
