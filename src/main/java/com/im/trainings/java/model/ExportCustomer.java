package com.im.trainings.java.model;

public class ExportCustomer extends Customer {


    @Override
    public void generateCreditBalance() {
        System.out.println("Generating creditBalance for Export Customer in : " + this.getClass().getName());
    }
}
