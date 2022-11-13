package com.company._1warsztat.podsumowanieGeneryki_1.firstExample;

// ten typ generyczny przyjmeiemy kazdy który bedzie implementował ten interface
//public class Sock<T extends Swimmable> {

// jeżeli w interfejsie Swimmable byłaby jakas metoda to mozemy ja wykorzystac w np. metodzie put
//ponieważ tak jak wyżej było napisane że ten typ generyczny będzie przyjmował tylko elementy implementujace Swimmable
    public class Sock<T> {
    private T item;

    public boolean put(T element){
        if(this.item == null || !this.item.equals(element)){
            this.item = element;
            return true;
        }
        return false;
    }

    public T getItem() {
        return item;
    }
}
