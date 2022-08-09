package com.nashintern.travelagent.model;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TourInfo {
    private Integer id;
    private String name;
    private Integer maxSlot;
    private Integer duration;
    private Double pricePerPerson;
    private Boolean isOneTime;
    private List<Destination> schedule;
    private List<String> imageURL;
}
