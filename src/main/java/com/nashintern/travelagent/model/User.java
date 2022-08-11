package com.nashintern.travelagent.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tblUser")
public class User {
    @Id
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String tel;
    private String address;
    private String role;

    public static final class Role {
        public static final String ADMIN = "ROLE_ADMIN";
        public static final String AGENT = "ROLE_AGENT";
        public static final String CUSTOMER = "ROLE_CUSTOMER";
        public static final String TOUR_GUIDE = "ROLE_TOUR_GUIDE";
        private Role() {}
    }
}
