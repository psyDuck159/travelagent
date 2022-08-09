package com.nashintern.travelagent.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TourGuide extends User{
    public TourGuide(Integer id, String username, String password, String name, String email, String tel, String address, String role) {
        super(id, username, password, name, email, tel, address, role);
    }
}
