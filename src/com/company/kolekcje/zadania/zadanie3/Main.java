package com.company.kolekcje.zadania.zadanie3;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Employee> employees = new HashSet<>();

        Employee employee1 = new Employee("Jan", "Kowalski");
        Employee employee2 = new Employee("Jan", "Kowalski");
        Employee employee3 = new Employee("Jan", "Adamski");
        Employee employee4 = new Employee("Roman", "Adamski");
        Employee employee5 = new Employee("Roman", "Adamski");

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

        System.out.println(employees);



//        for (Employee employee : employees) {
//            System.out.println(employee);
//        }
    }
}
