package com.nashintern.travelagent.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String status = Status.CONFIRMING;
    private Double totalPrice;
    private String note;
    private String review;
    private Integer rating;
    @Column(name = "create_at")
    @CreationTimestamp
    private Date createAt;
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
