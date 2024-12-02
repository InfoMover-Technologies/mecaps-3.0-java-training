package com.im.trainings.java.model;

public class LocalCustomer extends Customer {

    @Override
    public void generateCreditBalance() {
        System.out.println("Generating creditBalance for Local Customer in " + this.getClass().getName());

    }
}
