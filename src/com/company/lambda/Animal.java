package com.company.lambda;

public class Animal implements Jumpable {

    @Override
    public boolean canJump(String s) {
        System.out.println("metoda canJum z animal");
        return s.contains("jump");
    }
}
