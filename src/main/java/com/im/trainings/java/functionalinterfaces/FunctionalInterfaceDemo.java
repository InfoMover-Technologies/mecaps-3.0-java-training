package com.im.trainings.java.functionalinterfaces;


import com.im.trainings.java.model.Customer;
import com.im.trainings.java.model.ExportCustomer;


/**
 * Functional Programming, Functional Interfaces & Lambda Expressions in Java
 * <p>
 * Learn Streams,
 */

@FunctionalInterface
interface TaxCalculator {

    // Function
    public int calculateTax(String state);

    // BiFunction
//      public int calculateTax(String state, String city);


    // Consumer
//    public void printTaxDetails(String state);

    // BiConsumer
//    public void printTaxDetails(String state, String city);

    // Predicate
//    public boolean isTaxApplicable(String state);

    // BiPredicate
//    public boolean isTaxApplicable(String state, String city);


    // Supplier
//    public List<String>  getStatesWhereTaxIsApplicable() ;


//    public int getDefaultTax(String state);
}

public class FunctionalInterfaceDemo {


    public static void main(String[] args) {

//        TaxCalculator taxCalculator = new TaxCalculator() {
//            @Override
//            public int calculateTax(String state) {
//                if (state.equals("MP")) {
//                    return 12;
//                } else if (state.equals("Maha")) {
//                    return 15;
//                } else {
//                    return 10;
//                }
//            }
//        };

        TaxCalculator taxCalculator = (String state) -> {
            if (state.equals("MP")) {
                return 12;
            } else if (state.equals("Maha")) {
                return 15;
            } else {
                return 10;
            }
        };
        TaxCalculator taxCalculator2 = state -> state.equals("MP") ? 15 : 10;

        java.util.function.Function<String, Integer> f1 = x -> x.length();

        java.util.function.Function<String, Customer> f2 = x -> new ExportCustomer();

        java.util.function.BiFunction<String, String, Integer> f3 = null;

        java.util.function.Predicate<String> f4 = null;

        java.util.function.BiPredicate<String, Integer> f5 = null;

        java.util.function.Consumer<String> f6 = null;

        java.util.function.BiConsumer<String, String> f7 = null;


        java.util.function.Supplier<String> f8 = () -> "InfoMover";

        java.util.function.Supplier<Customer> f9 = null;


    }
}
