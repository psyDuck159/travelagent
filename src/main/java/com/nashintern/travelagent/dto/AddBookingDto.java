package com.nashintern.travelagent.dto;

import com.nashintern.travelagent.model.Visitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddBookingDto {
    private List<Visitor> visitors;
    private String note;
    private Double totalPrice;
}
