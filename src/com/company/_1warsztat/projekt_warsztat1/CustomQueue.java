package com.company._1warsztat.projekt_warsztat1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;


public class CustomQueue<T> {
//    kolejka stworzona do naszej zwykłej kolejki
    private final Deque<T> queue;

    private final Deque<T> queueVip;
//    mapa stworzona do podnoszenia licznika
    private final Map<String, Integer> counterMap = new HashMap<>();

//    tu mamy mozliwosć wrzucenia jakiej kolwiek kolejki dla zwykłych klientów oraz VIP
//    rodzaj kolejki dodawany jest w Main
    public CustomQueue(Deque<T> queue, Deque<T> queueVip) {
        this.queue = queue;
        this.queueVip = queueVip;
    }


    public void welcomeVip(T item) {
        boolean isAdded = queueVip.offer(item);
        System.out.printf("%s came to the Vip queue. %s%n", item, isAdded);
        printTotalQueue();
    }

    public void welcome(T item) {
        boolean isAdded = queue.offer(item);
        System.out.printf("%s came to the queue. %s%n", item, isAdded);
        printTotalQueue();
    }

//    pobiera i zwieksza licznik
    public Integer getAndIncrementCounter(String key) {
//        tymczaswoy klucz rowna się -> jezeli podamy key(naszym kluczem jest imię i nazwisko a wartoscia licznik)
//        i w naszej mapie mamy taki key to wyciagamy jego counter
//        dla danego key. pozniej do mapylicznika dorzucamy po ten sam klucz licznik zwiekszony
//
        Integer tempCounter = counterMap.getOrDefault(key, 0);
        counterMap.put(key, ++tempCounter);
        return tempCounter;
    }

    public void enter() {
        if (queueVip.isEmpty()) {
            System.out.println("no item in Vip queue");
            System.out.println();
        } else {
            handleEnterByQueue(queueVip);
            return;
        }

        if (queue.isEmpty()) {
            System.out.println("no item in queue");
            System.out.println();
            return;
        }
        handleEnterByQueue(queue);

    }

    private void handleEnterByQueue(Deque<T> queue) {
        T itemEntered = queue.poll();
        System.out.printf("Processing queue: %s arrived at the store.%n", itemEntered);
        printTotalQueue();
    }

    public void leave(T item) {
        if (queueVip.contains(item)) {
            queueVip.remove(item);
            System.out.printf("Living vip queue: %s%n ", item);
            printTotalQueue();
        } else if (queue.contains(item)) {
            queue.remove(item);
            System.out.printf("Living queue: %s%n ", item);
            printTotalQueue();
        } else {
            System.out.println(item + " currently is not in the queue\n");
        }
    }

    private void printTotalQueue() {
        ArrayList<T> totalList = new ArrayList<>(queueVip);
        totalList.addAll(queue);
        System.out.println(totalList);
        System.out.println();
    }
}
