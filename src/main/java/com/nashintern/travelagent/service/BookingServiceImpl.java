package com.nashintern.travelagent.service;

import com.nashintern.travelagent.model.Booking;
import com.nashintern.travelagent.model.Visitor;
import com.nashintern.travelagent.repository.BookingRepo;
import com.nashintern.travelagent.repository.VisitorRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookingServiceImpl implements BookingService{
    private BookingRepo bookingRepo;
    private VisitorRepo visitorRepo;
    private Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("authen-principal: {}", authentication.getPrincipal());
        logger.info("authen-detail: {}", authentication.getDetails());
        logger.info("authen-credential: {}", authentication.getCredentials());

        booking.setTotalPrice(pricePerPerson * numberOfPerson);

//        booking = bookingRepo.save(booking);
//        for (Visitor v: booking.getVisitors()) {
//            v.setBooking(booking);
//            visitorRepo.save(v);
//        }
        return booking;
    }
}
