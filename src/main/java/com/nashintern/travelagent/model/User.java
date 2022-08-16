package com.nashintern.travelagent.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tblUser")
public class User implements Serializable, GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 255)
    private String username;

    @Column(nullable = false, unique = false, length = 255)
    private String password;

    @Column(nullable = true, unique = false, length = 255)
    private String name;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(nullable = true, unique = true, length = 12)
    private String tel;

    @Column(nullable = true, unique = false, length = 255)
    private String address;

    @Column(nullable = true, unique = false, length = 50)
    private String role = Role.CUSTOMER;

    @Override
    public String getAuthority() {
        return this.role;
    }

    public static final class Role {
        public static final String ADMIN = "ROLE_ADMIN";
        public static final String AGENT = "ROLE_AGENT";
        public static final String CUSTOMER = "ROLE_CUSTOMER";
        public static final String TOUR_GUIDE = "ROLE_TOUR_GUIDE";
        private Role() {}
    }
}
