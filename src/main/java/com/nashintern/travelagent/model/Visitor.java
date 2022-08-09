package com.nashintern.travelagent.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Visitor {
    private Integer id;
    private String name;
    private String gender;
    private Date dob;
}
