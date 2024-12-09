package com.im.trainings.java;

import com.im.trainings.java.model.Customer;
import com.im.trainings.java.model.ExportCustomer;
import com.im.trainings.java.model.Invoice;
import com.im.trainings.java.model.InvoiceVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MoreOnStreams {

    public static void main(String[] args) {

        // Assume that the invoices are obtained by the database call
        // And also assume that there are 1000 invoices.
        List<Invoice> invoices = List.of(
                new Invoice(101, 101, "Invoice Details 1"),
                new Invoice(102, 120, "Invoice Details 1"),
                new Invoice(103, 111, "Invoice Details 1"),
                new Invoice(104, 110, "Invoice Details 1"),
                new Invoice(105, 200, "Invoice Details 1"),
                new Invoice(106, 200, "Invoice Details 1")
        );

        // Assume that we have made a database call to get the list of customers (100s of customers);
        List<ExportCustomer> allCustomers = List.of(new ExportCustomer(101, "JPMC", "E"),
                new ExportCustomer(102, "Morgan Stanley", "E"));

        Map<Integer, ExportCustomer> customerMap = allCustomers.stream()
                .collect(Collectors.toMap(
                        ExportCustomer::getId,     // key mapper - gets the ID
                        Function.identity()        // value mapper - uses the entire customer object
                ));

        System.out.println(customerMap);

        List<InvoiceVO> invoiceVOs = invoices
                .stream()
                .map(invoice -> {
                    InvoiceVO invoiceVO = new InvoiceVO();
                    invoiceVO.setInvoiceId(invoice.getId());
                    invoiceVO.setInvoiceDetails(invoice.getInvoiceDetails());
                    invoiceVO.setCustomerId(invoice.getCustomerId());

                    /**
                     * Invoice database call to get the customer object by customerId and then get the name of the custoemr
                     * from the customer object
                     */
//                    Customer customer = new ExportCustomer(); // assume that this object is populated with the help of database call.

                    int customerIdInInvoice = invoice.getCustomerId();
                    ExportCustomer c = customerMap.get(customerIdInInvoice);
                    String nameOfTheCustomer = c.getName();
                    invoiceVO.setCustomerName(nameOfTheCustomer);


                    return invoiceVO;
                })
                .collect(Collectors.toList());


    }
}
