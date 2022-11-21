package com.company._1warsztat.zadanieComparatorAndComparable;

import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
        new Employee("Jan", "Abramowicz", 25, new BigDecimal("1450.4")),
        new Employee("Roman", "Klimek", 21, new BigDecimal("2450.2")),
        new Employee("Stefan", "Janowicz", 19, new BigDecimal("3422.12")),
        new Employee("Karol", "Czyz", 13, new BigDecimal("1000.23")),
        new Employee("Jan", "Abramowicz", 25, new BigDecimal("1233.32")),
        new Employee("Karol", "Rzymanek", 23, new BigDecimal("1111.2")),
        new Employee("Zbyszek", "Nowakowski", 89, new BigDecimal("4450.5")),
        new Employee("Przemek", "Abramowicz", 76, new BigDecimal("34.23")),
        new Employee("Adrian", "Kamienski", 11, new BigDecimal("6534.5")),
        new Employee("Adan", "Beilisz", 5, new BigDecimal("1450.32")));

        print(employees);
//        uzycie implementacji Comparator w klasie Employee
        Collections.sort(employees);
        print(employees);

//        stworzenie komparatora
        Comparator<Employee> comparator = Comparator
                .comparing((Employee e) -> e.getName()).reversed()
                .thenComparing((Employee e)->e.getSurname()).reversed()
                .thenComparing((Employee e)-> e.getAge())
                .thenComparing((Employee e) -> e.getSalary());

//        wykorzystanie komparatora
        employees.sort(comparator);
        print(employees);

//        odwrócenie poprzedniego komparatora
        Comparator<Employee> reverseComparator = comparator.reversed();
        employees.sort(reverseComparator);
        print(employees);


    }

//    metoda do wyświetlania listy użytkowników
    private static void print(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println();
    }
}
