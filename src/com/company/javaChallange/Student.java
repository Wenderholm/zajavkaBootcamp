package com.company.javaChallange;

import java.util.Objects;

public class Student {
    public String name;
    public String fullName;
    public Integer age;


    public Student(String name, String surname, Integer age){
        this.name= name;
        this.fullName = surname;
        this.age= age;
    }

    public void printData(){
        System.out.println(name+ " " + fullName + " : " + age);
    }

    public void showAllData(){
        System.out.println(name + " " + fullName + " : " + age);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(fullName, student.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, fullName);
    }

    @Override
    public String toString() {
        return name + " " + fullName;
    }
}
