package com.company.objectProgram.zadaniaProgramObiektowe.zadanie4;

public class Exercise {
    public static void main(String[] args) {
        exercise4();
    }

    private static void exercise4() {
        Examiner teacher = new Teacher("Nauczyciel" ,"Nauczycielski");
        Examinated[] students = new Student[]{
                new Student("Rafal", "Romanowski"),
                new Student("Roman", "Nowak"),
                new Student("Adam", "Kowalski")
        };
        System.out.println();

        Exam[] exams = teacher.createExam(students.length);

        for (int i = 0; i < students.length; i++) {
            students[i].writeExam(exams[i]);
        }
        System.out.println();
        teacher.evaluationExams(exams);
    }
}
