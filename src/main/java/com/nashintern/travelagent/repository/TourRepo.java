package com.nashintern.travelagent.repository;

import com.nashintern.travelagent.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepo extends JpaRepository<Tour, Integer> {

}
