package com.im.trainings.java.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private int employeeId;
    private String name;
    private String city;

    private List<EmployeeAddress> addresses;


    public Employee(int id, String name, String city) {

        this.employeeId = id;
        this.name = name;
        this.city = city;
    }


}
