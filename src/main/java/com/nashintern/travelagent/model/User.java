package com.nashintern.travelagent.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tblUser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 20)
    private String username;

    @Column(nullable = false, unique = false, length = 64)
    private String password;

    @Column(nullable = false, unique = false, length = 20)
    private String name;

    @Column(nullable = false, unique = true, length = 20)
    private String email;

    @Column(nullable = false, unique = true, length = 12)
    private String tel;

    @Column(nullable = false, unique = false, length = 20)
    private String address;

    @Column(nullable = true, unique = false, length = 20)
    private String role;

    public static final class Role {
        public static final String ADMIN = "ROLE_ADMIN";
        public static final String AGENT = "ROLE_AGENT";
        public static final String CUSTOMER = "ROLE_CUSTOMER";
        public static final String TOUR_GUIDE = "ROLE_TOUR_GUIDE";
        private Role() {}
    }
}
