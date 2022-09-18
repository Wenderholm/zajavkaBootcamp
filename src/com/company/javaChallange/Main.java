package com.company.javaChallange;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Decryptor DECRYPTOR = new Decryptor();
    private static final List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        Student student1 = new Student("Lech", "Pawlak", 30);
        student1.showAllData();

        System.out.println("-------------------------------");

        int amount = 5;

        for (int i = 0; i < amount; i++) {
            System.out.println("podaj imię");
            String name = sc.nextLine();

            System.out.println("podaj nazwisko");
            String surname = sc.nextLine();

            System.out.println("Podaj liczbę:");
            Integer age = sc.nextInt();
            sc.nextLine();

            Student uczen = new Student(name, surname, age);
            studentList.add(uczen);

        }
        DECRYPTOR.decrypt(studentList);
    }
}


