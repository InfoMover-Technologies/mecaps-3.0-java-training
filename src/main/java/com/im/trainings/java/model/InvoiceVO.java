package com.im.trainings.java.model;


import lombok.Data;

// Value Object class
@Data
public class InvoiceVO {


    private int invoiceId;
    private int customerId;
    private String customerName;
    private String invoiceDetails;

}
