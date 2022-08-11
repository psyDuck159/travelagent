package com.nashintern.travelagent.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tblTourInfo")
public class TourInfo {
    @Id
    private Integer id;
    private String name;
    private Integer maxSlot;
    private Integer duration;
    private Double pricePerPerson;
    private Boolean isOneTime;
    @OneToMany(mappedBy = "tourInfo")
    private List<Destination> schedule;
    @Transient
    private List<String> imageURL;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "agentId")
    private User agent;
}
