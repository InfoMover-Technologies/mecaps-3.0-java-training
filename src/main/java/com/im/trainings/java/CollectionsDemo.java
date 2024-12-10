package com.im.trainings.java;

import com.im.trainings.java.model.CityWiseEmployee;
import com.im.trainings.java.model.Customer;
import com.im.trainings.java.model.Employee;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectionsDemo {


    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Iftekhar");
        names.add("Priya");
        names.add("Mustafa");

        List<String> names2 = List.of("Iftekhar", "Umar Shaikh", "Ahmed Shaikh", "Anju", "Priya");

        System.out.println(names2);
        List<String> allShaikhsOfBhopal = new ArrayList<>();
        for (String s : names2) {
            if (s.contains("Shaikh")) {
                allShaikhsOfBhopal.add(s);
            }
        }
        System.out.println(" ---- ");

        System.out.println(allShaikhsOfBhopal);

        List<String> filteredValues2 = names2
                .stream()
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) {
                        return s.contains("Shaikh");
                    }
                })
                .collect(Collectors.toList());

        List<Employee> employees = List.of(
                new Employee(100, "Pranjal", "Bhopal"),
                new Employee(101, "Umar", "Bhopal"),
                new Employee(102, "Rehan", "Bhopal"),
                new Employee(106, "Prashant", "Bhopal"),
                new Employee(103, "Farhan", "Aberdeen"),
                new Employee(140, "Shaeista", "London"),
                new Employee(141, "Amin", "London")
        );


        List<Employee> bhopalEmps = employees
                .stream()
                .filter(emp -> emp.getCity().equals("Bhopal"))
                .collect(Collectors.toList());

        System.out.println(bhopalEmps);
        System.out.println(" -----  ");

        List<String> bhopalEmps2 = employees
                .stream()
                .filter(emp -> emp.getCity().equals("Bhopal"))
                .map(emp -> emp.getName())
                .collect(Collectors.toList());


        List<CityWiseEmployee> bhopalEmps3 = employees
                .stream()
                .filter(emp -> emp.getCity().equals("London"))
                .map(emp -> {
                    CityWiseEmployee cityWiseEmployee = new CityWiseEmployee();

                    cityWiseEmployee.setEmployeeId(emp.getEmployeeId());
                    cityWiseEmployee.setCity(emp.getCity());
                    return cityWiseEmployee;

                })
                .collect(Collectors.toList());


        System.out.println(" ---- ");
        System.out.println(bhopalEmps3);

        Map<String, List<Employee>> cityWiseEmps = employees
                .stream()
                .collect(Collectors.groupingBy(Employee::getCity));

        for (Map.Entry<String, List<Employee>> entry : cityWiseEmps.entrySet()) {

            System.out.println(entry.getKey());
            System.out.println(" ---- ");
            entry.getValue().forEach(emp -> System.out.println(emp.getName()));
            System.out.println("****************");


        }

        Set<String> cities = employees
                .stream()
                .map(Employee::getCity)
//                .collect(Collectors.toSet());
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(" ---- ");
        System.out.println(cities);

        Optional<String> firstCity = employees
                .stream()

                .peek(emp -> {
                    if (emp.getCity().equals("Bhopal")) {
                        emp.setCity(emp.getCity() + " - M.P");
                    }
                })
                .map(Employee::getCity)
//                .collect(Collectors.toSet());
//                .findFirst();
                .findAny();

        System.out.println(" ---- ");

        if (firstCity.isEmpty()) {
            System.out.println("No city found");
        } else {
            System.out.println(firstCity.get());
        }


        boolean empInThisCity = employees
                .stream()
                .map(Employee::getCity)
                .anyMatch(city -> city.equals("Indore"));
        System.out.println(empInThisCity);
//


//        System.out.println(names.get(0));
//        System.out.println(" ------------------ ");
//
//
//        Set<String> names2 = new HashSet<>();
//
//        names2.add("Iftekhar");
//        names2.add("Priya");
//        names2.add("Mustafa");
//        names2.add("Mustafa");
//
//        Iterator<String> i  =  names2.iterator();
//        for(String s : names2) {
//            System.out.println(s);
//        }


    }

}
