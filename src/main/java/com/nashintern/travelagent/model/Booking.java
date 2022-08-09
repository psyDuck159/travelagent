package com.nashintern.travelagent.model;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Booking {
    private Integer id;
    private String status;
    private Double totalPrice;
    private String note;
    private String review;
    private Integer rating;
    private Customer customer;
    private List<Visitor> visitors;
    private Tour tour;

    public class Status {
        public static final String CONFIRMING = "CONFIRMING";
        public static final String WAITING_FOR_PAY = "WAITING_FOR_PAY";
        public static final String BOOKED = "BOOKED";
        public static final String IN_TRAVEL = "IN_TRAVEL";
        public static final String COMPLETED = "COMPLETED";
        public static final String WAITING_FOR_CANCEL = "WAITING_FOR_CANCEL";
        public static final String REFUNDING = "REFUNDING";
        public static final String CANCELED = "CANCELED";
    }
}
