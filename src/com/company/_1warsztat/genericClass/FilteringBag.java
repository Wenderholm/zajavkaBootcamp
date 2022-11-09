package com.company._1warsztat.genericClass;

import java.util.function.Predicate;

public class FilteringBag <T,U extends Predicate<T>,V extends Predicate<T>> {

    private T element;

//    dzieki final chcemy aby filter1 i 2 były tworzone na etapie konstruktora
    private final U filter1;

    private final V filter2;

    public FilteringBag(U filter1, V filter2) {
        this.filter1 = filter1;
        this.filter2 = filter2;
    }

    public void pack(T element){
        if(filter1.test(element) && filter2.test(element)){
            this.element = element;
        }else{
            throw new RuntimeException("No way mate");
        }
    }

    public T empty(){
        T element = this.element;
        this.element = null;
        return element;
    }
}
