package com.nashintern.travelagent.service;

import com.nashintern.travelagent.model.Booking;
import com.nashintern.travelagent.model.Visitor;
import com.nashintern.travelagent.repository.BookingRepo;
import com.nashintern.travelagent.repository.VisitorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookingServiceImpl implements BookingService{
    private BookingRepo bookingRepo;
    private VisitorRepo visitorRepo;

    @Autowired
    public BookingServiceImpl(BookingRepo bookingRepo, VisitorRepo visitorRepo) {
        this.bookingRepo = bookingRepo;
        this.visitorRepo = visitorRepo;
    }

    @Override
    @Transactional
    public Booking addBooking(Booking booking) {
        double pricePerPerson = booking.getTour().getTourInfo().getPricePerPerson();
        int numberOfPerson = booking.getVisitors().size();

        booking.setTotalPrice(pricePerPerson * numberOfPerson);

        booking = bookingRepo.save(booking);
        for (Visitor v: booking.getVisitors()) {
            v.setBooking(booking);
            visitorRepo.save(v);
        }
        return booking;
    }
}
