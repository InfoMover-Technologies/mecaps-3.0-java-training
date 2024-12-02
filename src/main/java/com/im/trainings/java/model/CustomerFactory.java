package com.im.trainings.java.model;

public class CustomerFactory {


    public static Customer newCustomer(String type) {

        if (type.equals("E")) {
            return new ExportCustomer();
        } else {
            return new LocalCustomer();
        }

    }
}
