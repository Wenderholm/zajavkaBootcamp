package com.company.objectProgram.zadaniaProgramObiektowe.zadanie4;

import java.util.Random;

public class Student extends Person implements Examinated{

    public Student(String name, String surname) {
        super(name, surname);
        System.out.println("Creating students: " + name + " " + surname);
    }

    @Override
    public void writeExam(Exam exam) {
        exam.setOwner(this);

        Random random = new Random();
        Question[] questions = exam.getQuestions();

        for (Question question : questions) {
            int randomAnswerIndex = random.nextInt(question.getPossibleAnswerSize());
            System.out.println("Student: " + getName() + " " + getSurname()
                    + ", answering question: " + question.getContent()
                    + ", possible answer: " + question.getPossibleAnswers()
                    + ", answered: " + question.getPossibleAnswer(randomAnswerIndex)
                    + ", index:[ " + randomAnswerIndex + "]");
            question.answer(randomAnswerIndex);
        };
    }

    @Override
    public String toString() {
        return "Student: " + getName() + " " + getSurname();
    }
}
