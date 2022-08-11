package com.nashintern.travelagent.service;

import com.nashintern.travelagent.model.Tour;
import com.nashintern.travelagent.repository.TourRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourServiceImpl implements TourService{
    private TourRepo tourRepo;

    @Autowired
    public TourServiceImpl(TourRepo tourRepo) {
        this.tourRepo = tourRepo;
    }

    @Override
    public Tour getTourById(int id) {
        return tourRepo.findById(id).orElse(null);
    }
}
