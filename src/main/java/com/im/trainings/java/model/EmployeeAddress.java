package com.im.trainings.java.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAddress {


    private String street;
    private String state;


    public boolean equals(Object obj) {
        EmployeeAddress emp = (EmployeeAddress) obj;
        return (this.state.equals(emp.state));
    }

    @Override
    public int hashCode() {
        return this.state.hashCode();
    }
}
