package com.company.objectProgram.agregacja;

public class Student {
    String id;
    String name;
    Marks marks;

    public Student(String id, String name, Marks marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public void display(){
        System.out.println(id + " - " + name);
        System.out.println("Maths marks " + marks.maths);
        System.out.println("english marks " + marks.english);
        System.out.println("science marks " + marks.science);
    }
}
