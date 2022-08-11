package com.nashintern.travelagent.repository;

import com.nashintern.travelagent.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepo extends JpaRepository<Visitor, Integer> {
}
