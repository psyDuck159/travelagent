package com.nashintern.travelagent.controller;

import com.nashintern.travelagent.model.Tour;
import com.nashintern.travelagent.service.TourService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TourController {
    private TourService tourService;
    private Logger logger = LoggerFactory.getLogger(TourController.class);

    @Autowired
    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("tour/{id}")
    public ModelAndView getTourById(@PathVariable() Integer id) {
        logger.info("tour id: {}", id);
        Tour tour = tourService.getTourById(id);
        logger.info("tour: {}", tour);
        ModelAndView view = new ModelAndView();
        view.setViewName("tour_detail.html");
        view.addObject("tour", tour);
        return view;
    }
}
