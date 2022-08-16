package com.nashintern.travelagent.controller;

import com.nashintern.travelagent.dto.AddBookingDto;
import com.nashintern.travelagent.model.Booking;
import com.nashintern.travelagent.model.CustomUserDetails;
import com.nashintern.travelagent.model.Tour;
import com.nashintern.travelagent.service.BookingService;
import com.nashintern.travelagent.service.CustomUserDetailsService;
import com.nashintern.travelagent.service.TourService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookingController {
    private BookingService bookingService;
    private TourService tourService;
    private CustomUserDetailsService userDetailsService;

    private Logger logger = LoggerFactory.getLogger(BookingController.class);

    @Autowired
    public BookingController(BookingService bookingService,
                             TourService tourService,
                             CustomUserDetailsService userDetailsService) {
        this.bookingService = bookingService;
        this.tourService = tourService;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("booking")
    public String getAddBooking(@RequestParam("tourId") Integer tourId,
                             Model model) {
        // must login before booking
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken){
            return "signin-form";
        }
        Tour tour = tourService.getTourById(tourId);
        model.addAttribute("tour", tour);

        logger.info("authen-principal: {}", authentication.getPrincipal());
        logger.info("authen-detail: {}", authentication.getDetails());

        return "book_tour.html";
    }

    @PostMapping("booking")
    @ResponseBody
    public String postAddBooking(@RequestParam("tourId") Integer tourId,
                             @RequestBody AddBookingDto bookingDto,
                             Model model) {
        logger.info("totalPrice: {}", bookingDto.getTotalPrice() );
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken){
            return "signin-form";
        }

        logger.info("authen-principal: {}", authentication.getPrincipal());

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        logger.info("User: {} - {}", userDetails.getUsername(), userDetails.getPassword());

        Tour tour = new Tour();
        tour.setId(tourId);

        Booking booking = new Booking();

        booking.setVisitors(bookingDto.getVisitors());
        booking.setNote(bookingDto.getNote());
        booking.setTour(tour);
        booking.setTotalPrice(bookingDto.getTotalPrice());

        CustomUserDetails userDetails1 = (CustomUserDetails) userDetailsService.loadUserByUsername(userDetails.getUsername());
        booking.setCustomer(userDetails1.getUser());

        bookingService.addBooking(booking);

        return "Đặt thành công!!! Chờ xác nhận";
    }
}
