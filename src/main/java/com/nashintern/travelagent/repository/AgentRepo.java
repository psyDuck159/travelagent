package com.nashintern.travelagent.repository;

import com.nashintern.travelagent.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepo extends JpaRepository<Agent, Integer> {
}

