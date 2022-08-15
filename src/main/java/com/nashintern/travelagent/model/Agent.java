package com.nashintern.travelagent.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Agent extends User{
    private List<Tour> tours;

    public Agent(Integer id, String username, String password, String name, String email, String tel, String address, String role) {
        super(id, username, password, name, email, tel, address, role);
    }
}
