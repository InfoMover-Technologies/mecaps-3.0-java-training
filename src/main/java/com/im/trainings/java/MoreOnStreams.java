package com.im.trainings.java;

import com.im.trainings.java.model.Employee;
import com.im.trainings.java.model.ExportCustomer;
import com.im.trainings.java.model.Invoice;
import com.im.trainings.java.model.InvoiceVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * We have covered the following topics in streams
 * <hr/>
 * <ol>
 *     <li>.stream() on any collection will provide a stream of elements in that collection,
 *     so that you can iterate over its elements</li>
 *
 *     <li>List, Set, Map (key, value) | ConcurrentHashMap data structures</li>
 *     <li>Functional interfaces : java.util.function.Function, BiFunction, Predicate, ByPredicate, Consumer, BiConsumer</li>
 *
 *     <li>You stream over elements to ?
 *     <ol>
 *         <li>.filter() : using Predicate</li>
 *         <li>.map() : to perform transformations - using Function</li>
 *         <li>.findFirst() : to perform transformations - using Function</li>
 *         <li>.anyMatch() : to perform transformations - using Function</li>
 *         <li>.findAny() : to perform transformations - using Function</li>
 *     </ol>
 *     </li>
 *     <li>
 *         Optional<Integer> : empty() true if no Integer in it or else it will return false
 *     </li>
 *
 * </ol>
 * <p>
 * <hr/>
 * things to discuss
 * <ol>
 *     <li>method reference</li>
 *     <li>syntactic sugar</li>
 * </ol>
 */
public class MoreOnStreams {

    public static void main(String[] args) {

        Map<String, Employee> employeeMap = new HashMap<>();
        employeeMap.put("101", new Employee(101, "Pranjal", "Bhopal"));
        employeeMap.put("102", new Employee(102, "Rehan", "Bhopal"));
        employeeMap.put("103", new Employee(103, "Umar", "Bhopal"));


        Employee e = employeeMap.get("101");
        System.out.println(e);

//        Map<String, Employee> demo = new HashMap<>();

//        Set<Map.Entry<String, Employee>> entrySet =
        List<String> empNames = employeeMap.entrySet()
                .stream()
                .peek(x -> {

                    String key = x.getKey();
                    Employee emp = x.getValue();
                    //                    System.out.println(key + " -- " + emp);

                })
//                .map(x -> {
//                    String key = x.getKey();
//                    Employee emp = x.getValue();
//                    /**
//                     *
//                     */
//                    return emp.getName();
//
//                })
                // static method reference (referring to the method that is static in the class)
                .map(MoreOnStreams::transformEntryOfStringAndEmployeeToNameOfEmployee)
                .collect(Collectors.toList());

        System.out.println(empNames);
//        empNames.forEach(x -> {
//            System.out.println(x);
//        });
        // referring to the object method: println is the method in the object called out which is declared as static in System
        empNames.forEach(System.out::println);

        if (true) {
            return;
        }

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
                        ExportCustomer::getId,
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

    public static String transformEntryOfStringAndEmployeeToNameOfEmployee(Map.Entry<String, Employee> employeeEntry) {

        String key = employeeEntry.getKey();
        Employee emp = employeeEntry.getValue();
        /**
         *
         */
        return emp.getName();

    }
}
