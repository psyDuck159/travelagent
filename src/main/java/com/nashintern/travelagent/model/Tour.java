package com.nashintern.travelagent.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Tour {
    private Integer id;
    private String departure;
    private Date departureTime;
    private TourGuide tourGuide;
    private TourInfo tourInfo;
}
