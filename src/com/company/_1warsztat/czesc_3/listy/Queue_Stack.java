package com.company._1warsztat.czesc_3.listy;

import java.util.*;

public class Queue_Stack {
    public static void main(String[] args) {
        List<Integer> input = List.of(1,5,9,1,28,1,63,2);


        Deque<Integer> stack = new ArrayDeque<>();
        for (Integer element : input) {
            stack.push(element);
            System.out.println(stack);
        }

        int size = stack.size();

        for (int i = 0; i < size; i++) {
            System.out.println("stack.peek : " + stack.peek());
            System.out.println(stack);
            System.out.println("stack.pop : " + stack.pop());
            System.out.println(stack);
        }



    }
}
