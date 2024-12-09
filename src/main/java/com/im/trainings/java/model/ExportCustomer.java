package com.im.trainings.java.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExportCustomer extends Customer implements Billable, Cloneable, Runnable {

    private int id;
    private String name;
    private String customerType;

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

    @Override
    public ExportCustomer clone() {
        try {
            return (ExportCustomer) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
