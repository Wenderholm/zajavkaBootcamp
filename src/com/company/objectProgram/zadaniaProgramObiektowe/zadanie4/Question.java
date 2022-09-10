package com.company.objectProgram.zadaniaProgramObiektowe.zadanie4;

import java.util.Arrays;

public class Question {
    private final int id;

    private final String content;

    private final String[] possibleAnswers;

    private final int goodAnswerIndex;

    private int giveAnswerIndex;

    public Question(int id, String content, String[] possibleAnswers, int goodAnswerIndex) {
        this.id = id;
        this.content = content;
        this.possibleAnswers = possibleAnswers;
        this.goodAnswerIndex = goodAnswerIndex;

    }

    public String getPossibleAnswers() {
        return Arrays.toString(possibleAnswers);
    }

    public String getPossibleAnswer(int index){
        return possibleAnswers[index];
    }

    public int getPossibleAnswerSize(){
        return possibleAnswers.length;
    }

    public String getContent(){
        return content;
    }

    public void answer(int index){
        this.giveAnswerIndex = index;
    }

    boolean isCorrectlyAnswered(){
        System.out.println("Question: " + id
                + ", content='" + content +
                ", goodAnswerIndex=" + goodAnswerIndex +
                ", giveAnswerIndex=" + giveAnswerIndex);
        return goodAnswerIndex == giveAnswerIndex;
    }
}
