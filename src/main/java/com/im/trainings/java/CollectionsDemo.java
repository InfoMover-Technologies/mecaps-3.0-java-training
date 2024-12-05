package com.im.trainings.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionsDemo {


    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Iftekhar");
        names.add("Priya");
        names.add("Mustafa");

        List<String> names2 = List.of("Iftekhar", "Umar Shaikh", "Ahmed Shaikh", "Anju", "Priya");

        System.out.println(names2);
        List<String> allShaikhsOfBhopal = new ArrayList<>();
        for (String s : names2) {
            if (s.contains("Shaikh")) {
                allShaikhsOfBhopal.add(s);
            }
        }
        System.out.println(" ---- ");

        System.out.println(allShaikhsOfBhopal);

        List<String> filteredValues2 = names2
                .stream()
                .filter(x -> x.contains("Shaikh"))
                .collect(Collectors.toList());

        System.out.println(" ****** ");
        System.out.println(filteredValues2);








//        System.out.println(names.get(0));
//        System.out.println(" ------------------ ");
//
//
//        Set<String> names2 = new HashSet<>();
//
//        names2.add("Iftekhar");
//        names2.add("Priya");
//        names2.add("Mustafa");
//        names2.add("Mustafa");
//
//        Iterator<String> i  =  names2.iterator();
//        for(String s : names2) {
//            System.out.println(s);
//        }


    }

}
