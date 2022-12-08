package com.company._2warsztat.interfejsy_funkcyjne.Projekt;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Transformer {

    public static<T, R extends Number> Function<T, R> getFunctionImpl() {
        return (T t) -> (R) Integer.valueOf(t.toString().length());
    }


    public static<T> UnaryOperator<T> getUnaryOperatorImpl() {
        return (T t) -> t;
    }
}
