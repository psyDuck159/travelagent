package com.nashintern.travelagent.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Destination {
    private Integer id;
    private String name;
    private String content;
    private Integer day;
    private City city;
}
