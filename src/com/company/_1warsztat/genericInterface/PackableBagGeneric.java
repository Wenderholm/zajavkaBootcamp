package com.company._1warsztat.genericInterface;

public class PackableBagGeneric<T> implements Packable<T> {
    @Override
    public void pack(T element) {

    }

    @Override
    public T empty() {
        return null;
    }
}

// WAZNE 5 rzeczy których nie mozna zrobic
//1. nie mozemy stworzyc konstruktora generyka
//T newElement = new T(); <- po kompilacji będzie to Object nie ma sensu tworzyć objekt

//2. nie mozna tworzyć tablicy
// private T[] arr
// arr= new[0]

//3. nie mozemy zawołac instanceof

//4. nie mozna jako typu generycznego uzuwać prymitywu ponieważ wszystko zamieniane jest na Objece a
// prymityw nie moze byc Object

//5. nie mozna tego używać w kontekscie statycznym
// private static T variable;
// ponieważ kontekst statyczny jest wcześniej niż klasa i on jeszcze nie wie jaki typ będzie wstawiony w klasie