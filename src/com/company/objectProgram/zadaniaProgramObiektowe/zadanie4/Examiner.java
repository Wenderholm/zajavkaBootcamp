package com.company.objectProgram.zadaniaProgramObiektowe.zadanie4;

public interface Examiner {
    Exam[] createExam(int numberOfStudents);

    void evaluationExams(Exam[] exams);
}
