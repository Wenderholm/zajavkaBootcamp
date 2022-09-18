package com.company.staticWord.Zadania;

public class Teacher    {

    private static Student student1 = new Student();
    private static Student student2 = new Student();

    public static void main(String[] args) {
        student1.age = 28;
        student2.age = 21;
        System.out.println(student1.age);
        System.out.println(student2.age);
    }
}
