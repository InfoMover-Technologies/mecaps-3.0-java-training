package com.im.trainings.java;

import com.im.trainings.java.model.Employee;
import com.im.trainings.java.model.EmployeeAddress;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMapDemo {


    public static void main(String[] args) {


        List<Employee> employees = List.of(
                new Employee(100, "Pranjal", "Bhopal",


                        List.of(new EmployeeAddress("Kohefiza", "M.P"),
                                new EmployeeAddress("Hinjewadi", "Maharashtra"))

                ),


                new Employee(101, "Umar", "Bhopal",
                        List.of(new EmployeeAddress("Street 2", "M.P"),
                                new EmployeeAddress("Some Street", "Maharashtra"))

                ),
                new Employee(102, "Rehan", "Bhopal",

                        List.of(new EmployeeAddress("Kohefiza", "M.P"),
                                new EmployeeAddress("Andheri", "Maharashtra"))

                ),
                new Employee(106, "Prashant", "Bhopal",
                        List.of(new EmployeeAddress("Bada Taalaab", "M.P"),
                                new EmployeeAddress("Hinjewadi", "Maharashtra"))

                ),
                new Employee(103, "Farhan", "Aberdeen",
                        List.of(
                                new EmployeeAddress("Bradstreet", "Scotland"))

                ),
                new Employee(140, "Shaeista", "London",
                        List.of(new EmployeeAddress("Andheri", "Maharashtra"),
                                new EmployeeAddress("Croydon", "England"))

                ),
                new Employee(141, "Amin", "London",
                        List.of(new EmployeeAddress("Andheri", "Maharashtra"),
                                new EmployeeAddress("Croydon", "England"))

                )
        );

//        List<List<EmployeeAddress>> empsFromMaharashtra = employees
//                .stream()
//                .filter(emp -> {
//
//                    List<EmployeeAddress> empAddresses = emp.getAddresses();
//                    return empAddresses
//                            .stream()
//                            .anyMatch(empAddress ->
//                                    empAddress
//                                            .getState().equals("Maharashtra"));
//
//
//                })
//                .map(emp -> emp.getAddresses())
//                .toList();
        Set<EmployeeAddress> empsFromMaharashtra = employees
                .stream()
                .filter(emp -> {

                    List<EmployeeAddress> empAddresses = emp.getAddresses();
                    return empAddresses
                            .stream()
                            .anyMatch(empAddress ->
                                    empAddress
                                            .getState().equals("Maharashtra"));


                })
                .flatMap(emp -> emp.getAddresses().stream())
                .collect(Collectors.toSet());

        empsFromMaharashtra.forEach(System.out::println);

    }


}
