package com.company._1warsztat.czesc_2.zadanieComparatorAndComparable;

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

    @Override
    public String toString() {
        return "Employee: " + name +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", salary=" + salary;
    }


//    METODA COMPARETO W SPOSOB NORMALNY
//    @Override
//    public int compareTo(Employee other) {
//        int nameCompare = name.compareTo(other.name);
//        if(nameCompare != 0){
//            return nameCompare;
//        }
//
//        int surnameCompare = other.surname.compareTo(surname);
//        if(surnameCompare != 0){
//            return surnameCompare;
//        }
//
//        int ageCompare = age.compareTo(other.age);
//        if(ageCompare != 0){
//            return ageCompare;
//        }
//
//        return other.salary.compareTo(salary);
//    }

//    METODA COMPARE TO Z UZYCIEM COMPARATORA
    @Override
    public int compareTo(Employee employee) {
//        Comparator<Employee> comparingName = Comparator.comparing(e -> e.name);
//        Comparator<Employee> comparingSurname = comparingName.thenComparing(e -> e.surname).reversed();
//        Comparator<Employee> compareAge = comparingSurname.thenComparing(e -> e.age);
//        Comparator<Employee> comparingSalary = compareAge.thenComparing(e -> e.salary).reversed();
//        return comparingSalary.compareTo(this, employee);

//        powyzsze za pomoca shortcut CTRL+ALT+N wyglada tak
//        return Comparator
//                .<Employee, String>comparing(e1 -> e1.name)
//                .thenComparing(e2 -> e2.surname).reversed()
//                .thenComparing(e1 -> e1.age)
//                .thenComparing(e -> e.salary).reversed()
//                .compare(this, employee);

//        JESZCZE INNY SPOSÓB ZAPISU POWYZSZEGO

        return Comparator
                .<Employee, String>comparing(e -> e.name)
                .thenComparing((e1,e2) -> e2.surname.compareTo(e1.surname))
                .thenComparing(e1 -> e1.age)
                .thenComparing((e1,e2) -> e2.salary.compareTo(e1.salary))
                .compare(this, employee);
//        jezeli zamienimy this z employee to wykonamy reverse na całości
    }
}
