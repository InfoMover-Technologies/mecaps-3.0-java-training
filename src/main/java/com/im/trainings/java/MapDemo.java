package com.im.trainings.java;

import com.im.trainings.java.model.Customer;
import com.im.trainings.java.model.CustomerFactory;

import java.util.*;

public class MapDemo {

    public static void main(String[] args) {


//        List<String> names = new ArrayList<>();
        List<String> names = new LinkedList<>();

        names.add("John");
        names.add("Jane");

        System.out.println(names.size());

//        Map<Integer, Customer> employeeMap = new HashMap<>();
        Map<Integer, Customer> employeeMap = new Hashtable<>();
        Customer c1 = CustomerFactory.newCustomer("E");
        Customer c2 = CustomerFactory.newCustomer("L");


        Map<Integer, Map<String, Customer>> example = new TreeMap<>();

        Map<String, Customer> h1 = new HashMap<>();
        h1.put("103", CustomerFactory.newCustomer("D"));

        example.put(101, h1);


        c1.setId(101);
        c1.setName("JPMC");
        c2.setId(102);
        c2.setName("Morgan Stanley");



        employeeMap.put(101, c1);
        employeeMap.put(102, c2);

        for (Map.Entry<Integer, Customer> entry : employeeMap.entrySet()) {


            System.out.println(entry.getKey() + " " + entry.getValue());

        }

        System.out.println(employeeMap.get("102"));


    }
}
