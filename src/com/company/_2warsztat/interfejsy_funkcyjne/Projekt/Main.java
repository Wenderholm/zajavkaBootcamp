package com.company._2warsztat.interfejsy_funkcyjne.Projekt;

import java.util.Locale;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

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

        System.out.println("----------------------------------");

        Function<String, Integer> myFunction2 = Transformer.getFunctionImpl();
        Optional<Integer> myOptional = Optional.of("myString").map(myFunction2);
        System.out.println(myOptional);

        UnaryOperator<String> myFunction3 = Transformer.getUnaryOperatorImpl();
        Optional<String> someValue = Optional.of("someValue").map(myFunction3);
        System.out.println(someValue);

        System.out.println("----------------------------------");

        MyConsumer myConsumer = new MyConsumer();
        myConsumer.consumerMethod(c -> System.out.println("consumowane: " + c));
        myConsumer.supplierMethod( () -> "abc");
        myConsumer.functionMethod( s -> s.toLowerCase(Locale.ROOT));

        System.out.println("------------test-----------------");

        myConsumer.consumerMethod(muConsumer);
        myConsumer.supplierMethod(mySupplier);
        myConsumer.functionMethod(myFunction);
    }
}
