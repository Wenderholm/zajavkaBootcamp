package com.company._1warsztat.genericInterface;

public interface Packable<T> {

    void pack(T element);

    T empty();
}
