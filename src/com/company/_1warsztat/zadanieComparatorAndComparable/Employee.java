package com.company._1warsztat.zadanieComparatorAndComparable;

import java.math.BigDecimal;
import java.util.Comparator;

public class Employee implements Comparable<Employee> {
    private final String name;
    private final String surname;
    private final Integer age;
    private final BigDecimal salary;

    public Employee(String name, String surname, Integer age, BigDecimal salary) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee: " + name +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", salary=" + salary;
    }


    @Override
    public int compareTo(Employee other) {
        int nameCompare = name.compareTo(other.name);
        if(nameCompare != 0){
            return nameCompare;
        }

        int surnameCompare = other.surname.compareTo(surname);
        if(surnameCompare != 0){
            return surnameCompare;
        }

        int ageCompare = age.compareTo(other.age);
        if(ageCompare != 0){
            return ageCompare;
        }

        return other.salary.compareTo(salary);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public BigDecimal getSalary() {
        return salary;
    }
}
