package com.company._2warsztat.interfejsy_funkcyjne.Projekt;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MyConsumer {
    public void consumerMethod(Consumer<String> cons){
        cons.accept("myArg");
    }

    public void supplierMethod(Supplier<String> sup){
        System.out.println(sup.get());
    }

    public void functionMethod(Function<String,String> fun){
        System.out.println(fun.apply("someString"));
    }
}
