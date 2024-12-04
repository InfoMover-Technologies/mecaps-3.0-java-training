package com.im.trainings.java.model;

public class ExportCustomer extends Customer implements Billable, Cloneable, Runnable {


    @Override
    public void generateCreditBalance() {
        System.out.println("Generating creditBalance for Export Customer in : " + this.getClass().getName());
    }

    @Override
    public int raiseInvoice() {
        return 0;
    }


    @Override
    public void run() {

    }
}
