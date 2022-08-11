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
@Table(name = "tblBooking")
public class Booking {
    @Id
    private Integer id;
    private String status;
    private Double totalPrice;
    private String note;
    private String review;
    private Integer rating;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "customerId")
    private User customer;
    @OneToMany(mappedBy = "booking")
    private List<Visitor> visitors;
    @ManyToOne
    @JoinColumn(name = "tourId")
    private Tour tour;

    public static class Status {
        public static final String CONFIRMING = "CONFIRMING";
        public static final String WAITING_FOR_PAY = "WAITING_FOR_PAY";
        public static final String BOOKED = "BOOKED";
        public static final String IN_TRAVEL = "IN_TRAVEL";
        public static final String COMPLETED = "COMPLETED";
        public static final String WAITING_FOR_CANCEL = "WAITING_FOR_CANCEL";
        public static final String REFUNDING = "REFUNDING";
        public static final String CANCELED = "CANCELED";
        private Status() {}
    }
}
