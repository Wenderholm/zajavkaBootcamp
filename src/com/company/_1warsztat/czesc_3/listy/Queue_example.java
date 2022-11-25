package com.company._1warsztat.czesc_3.listy;

import java.util.*;

public class Queue_example {
    public static void main(String[] args) {
        List<Integer> input = List.of(1,5,9,1,28,1,63,2);


        Queue<Integer> queue = new ArrayDeque<>();
//        zapisywanie do kolejki
        for (Integer element : input) {
            queue.offer(element);
//            System.out.println("queue.offer: " + queue.offer(element) + ", added element: " + element);
//            System.out.println(queue);
        }

//        odczytywanie z kolejki
//        int size = queue.size();
//        for (int i = 0; i < size; i++) {
////            peek zerka na kolejke i nie sciaga elementu
//            System.out.println("queue.peek : " + queue.peek());
//            System.out.println(queue);
////            poll zerka na kolejke i sciaga element z kolejki
//            System.out.println("queue.poll : " + queue.poll());
//            System.out.println(queue);
//        }


        Deque<Integer> queue2 = new LinkedList<>();
//        Deque<Integer> queue2 = new ArrayDeque<>();
//        ArrayDeque<Integer> queue2 = new ArrayDeque<>();
        for (Integer element : input) {
            queue2.offer(element);
        }
        System.out.println(queue2);
        queue2.addFirst(101);
        System.out.println(queue2);
        queue2.addLast(901);
        System.out.println(queue2);
    }
}
