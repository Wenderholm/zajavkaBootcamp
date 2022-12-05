package com.company._2warsztat.interfejsy_funkcyjne;

import java.util.function.Supplier;

public class LambdaException {
    public static void main(String[] args) {
        Supplier<String> supplier1 = LambdaException::wrapped;
        Supplier<String> supplier2 = LambdaException::stringCreationUnchecked;
    }

    private static String wrapped() {
        try {
            return stringCreationChecked();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String stringCreationChecked() throws Exception{
        return "stringCreationChecked";
    }

    private static String stringCreationUnchecked() throws RuntimeException{
        return "stringCreationUnchecked";
    }
}
