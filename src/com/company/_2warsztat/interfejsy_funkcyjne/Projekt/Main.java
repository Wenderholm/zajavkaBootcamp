package com.company._2warsztat.interfejsy_funkcyjne.Projekt;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Producer<String> myProducer = new Producer<>();
        Supplier<String> mySupplier = myProducer.getSupplierImpl("someStringToCheck");
        System.out.println(mySupplier.get());

        Consumer<String> muConsumer = myProducer.getConsumerImpl();
        muConsumer.accept("someConsumerString");

        Function<String,String> myFunction = myProducer.getFunctionImpl("aaa");
        String jak = myFunction.apply("b");
        System.out.println(jak);

        Function<String, Integer> myFunction2 = Transformer.getFunctionImpl();
        Optional<Integer> myOptional = Optional.of("myString").map(myFunction2);
        System.out.println(myOptional);

    }
}
