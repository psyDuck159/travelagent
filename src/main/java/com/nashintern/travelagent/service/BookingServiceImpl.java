package com.nashintern.travelagent.service;

import com.nashintern.travelagent.model.Booking;
import com.nashintern.travelagent.model.Visitor;
import com.nashintern.travelagent.repository.BookingRepo;
import com.nashintern.travelagent.repository.TourRepo;
import com.nashintern.travelagent.repository.VisitorRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookingServiceImpl implements BookingService{
    private BookingRepo bookingRepo;
    private VisitorRepo visitorRepo;
    private TourRepo tourRepo;
    private Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);

    @Autowired
    public BookingServiceImpl(BookingRepo bookingRepo,
                              VisitorRepo visitorRepo,
                              TourRepo tourRepo) {
        this.bookingRepo = bookingRepo;
        this.visitorRepo = visitorRepo;
        this.tourRepo = tourRepo;
    }

    @Override
    @Transactional
    public Booking addBooking(Booking booking) {
        int availableSlot = tourRepo.getAvailableSlot(booking.getTour().getId());
        int numberPassenger = booking.getVisitors().size();

        if (numberPassenger > availableSlot){
            throw new RuntimeException("Còn " + availableSlot + " chỗ, không đủ cho " + numberPassenger + " người.");
        }
        logger.info("enough slot");

        booking = bookingRepo.save(booking);
        for (Visitor v: booking.getVisitors()) {
            v.setBooking(booking);
            visitorRepo.save(v);
        }
        return booking;
    }
}
