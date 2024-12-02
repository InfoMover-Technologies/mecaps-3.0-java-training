package com.im.trainings.java;

import com.im.trainings.java.model.Customer;
import com.im.trainings.java.model.CustomerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {


    public static void main(String[] args) {


        int i1 = 25;
        int i2 = 25;


        System.out.println(i1 == i2);

        String name1 = new String("Shakir"); // literal
        String name2 = new String("shakir");

        System.out.println("name 1 == name2 : " + (name1.equals(name2)));

        /**
         * Client class must be dependent on abstraction not on implementation
         */

        Customer c1 = CustomerFactory.newCustomer("E");
        Customer c2 = CustomerFactory.newCustomer("L");
        Customer c3 = CustomerFactory.newCustomer("E");

        c3.setId(102);
        c3.setName("Wipro");

        c1.setId(101);
        c2.setId(101);
        c1.printCustomerDetails();
        c2.printCustomerDetails();


//        c1.setCustomerType("E");
//        c2.setCustomerType("L");

        c1.generateCreditBalance();
        c2.generateCreditBalance();


        c1.setName("JPMC");

        c2.setName("Morgan Stanley");

        System.out.println("comparing c1 and c2 : " + c1.equals(c2));

        ArrayList<String> names = new ArrayList<>();

        names.add("v1");
        names.add("v1");
        names.add("v1");

        System.out.println(names);

        HashSet<String> names2 = new HashSet<>();

        names2.add("v1");
        names2.add("v1");
        names2.add("v1");

        System.out.println(names2);

//        HashSet<Customer> customers = new HashSet<>();
        TreeSet<Customer> customers = new TreeSet<>();


        customers.add(c1);
        customers.add(c2);

        System.out.println(customers);



        customers.add(c3);

        System.out.println(customers);


    }

}


