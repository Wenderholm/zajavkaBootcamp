package com.company._2warsztat.wstepLambda;

public class LambdaExample {
    public static void main(String[] args) {
        ILambda lambda = someWord -> someWord.length();
        System.out.println(lambda.charSum("janeka ma kota i tak dalej"));
    }
}
