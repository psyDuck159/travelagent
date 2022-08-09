package com.nashintern.travelagent.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Customer extends User{
    private Date dob;

    public Customer(Integer id, String username, String password, String name, String email, String tel, String address, String role) {
        super(id, username, password, name, email, tel, address, role);
    }
}
