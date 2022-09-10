package com.company.enumeratory.bookExercise;

public class Main {
    public static void main(String[] args) {
        Question q1 = new Question();
        AskMe askMe = new AskMe();

        askMe.answer(q1.ask());
        askMe.answer(q1.ask());
        askMe.answer(q1.ask());
        askMe.answer(q1.ask());

    }
}
