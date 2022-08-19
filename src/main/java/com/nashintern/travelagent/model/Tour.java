package com.nashintern.travelagent.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tblTour")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String departure;
    @Column
    private Date departureTime;
    @Transient
    private Integer availableSlot;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "tourGuideId")
    private User tourGuide;
    @ManyToOne
    @JoinColumn(name = "tourInfoId")
    private TourInfo tourInfo;
}
