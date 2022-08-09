package com.nashintern.travelagent.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String tel;
    private String address;
    private String role;

    public class Role {
        public static final String ADMIN = "ROLE_ADMIN";
        public static final String AGENT = "ROLE_AGENT";
        public static final String CUSTOMER = "ROLE_CUSTOMER";
    }
}
