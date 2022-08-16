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
        Tour tour = tourRepo.findById(id).orElse(null);
        if (tour != null) {
            tour.setAvailableSlot(getAvailableSlot(id));
        } else {
            throw new RuntimeException("Tour not found");
        }
        return tour;
    }

    @Override
    public int getAvailableSlot(int tourId) {
        return tourRepo.getAvailableSlot(tourId);
    }
}
