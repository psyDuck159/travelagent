package com.nashintern.travelagent.controller;

import com.nashintern.travelagent.model.Booking;
import com.nashintern.travelagent.model.Tour;
import com.nashintern.travelagent.service.BookingService;
import com.nashintern.travelagent.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BookingController {
    private BookingService bookingService;
    private TourService tourService;

    @Autowired
    public BookingController(BookingService bookingService,
                             TourService tourService) {
        this.bookingService = bookingService;
        this.tourService = tourService;
    }

    @GetMapping("booking?tourId={tourId}")
    public String addBooking(@PathVariable Integer tourId,
                             Model model) {
        //TODO: get customer from SecurityContextHolder
        Tour tour = tourService.getTourById(tourId);
        model.addAttribute("tour", tour);
        return "book_tour.html";
    }
}
