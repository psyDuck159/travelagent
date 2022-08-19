package com.nashintern.travelagent.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tblDestination")
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String content;
    private Integer day;
    @ManyToOne
    @JoinColumn(name = "cityId")
    private City city;
    @ManyToOne
    @JoinColumn(name = "tourInfoId")
    private TourInfo tourInfo;
}
