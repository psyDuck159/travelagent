package com.nashintern.travelagent.controller;

import com.nashintern.travelagent.dto.AddBookingDto;
import com.nashintern.travelagent.model.Booking;
import com.nashintern.travelagent.model.Tour;
import com.nashintern.travelagent.model.Visitor;
import com.nashintern.travelagent.service.BookingService;
import com.nashintern.travelagent.service.TourService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookingController {
    private BookingService bookingService;
    private TourService tourService;
    private Logger logger = LoggerFactory.getLogger(BookingController.class);

    @Autowired
    public BookingController(BookingService bookingService,
                             TourService tourService) {
        this.bookingService = bookingService;
        this.tourService = tourService;
    }

    @GetMapping("booking")
    public String getAddBooking(@RequestParam("tourId") Integer tourId,
                             Model model) {
        Tour tour = tourService.getTourById(tourId);
        model.addAttribute("tour", tour);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("authen-principal: {}", authentication.getPrincipal());
        logger.info("authen-detail: {}", authentication.getDetails());
        logger.info("authen-credential: {}", authentication.getCredentials());
        return "book_tour.html";
    }

    @PostMapping("booking")
    public String postAddBooking(@RequestParam("tourId") Integer tourId,
                             @RequestBody AddBookingDto bookingDto,
                             Model model) {
        //TODO: get customer from SecurityContextHolder and set to booking
        Tour tour = new Tour();
        tour.setId(tourId);

        Booking booking = new Booking();
        booking.setVisitors(bookingDto.getVisitors());
        booking.setNote(bookingDto.getNote());

        logger.info("Booking-> size: {}, note: {}", booking.getVisitors().size(), booking.getNote());
        for (Visitor v : booking.getVisitors()) {
            logger.info("Visitor: {} , {}, {}", v.getName(), v.getGender(), v.getDob());
        }

        booking.setTour(tour);
        bookingService.addBooking(booking);

        return "Đặt thành công!!! Chờ xác nhận";
    }
}
