package com.company._1warsztat.podsumowanieGeneryki_1.firstExample;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Sock<String> sock1 = new Sock<>();
        System.out.println(sock1.getItem());
        System.out.println(sock1.put("cash"));
        System.out.println(sock1.getItem());

        Sock<List<String>> sock2 = new Sock<>();
        System.out.println(sock2.getItem());
        System.out.println(sock2.put(List.of("cash", "money")));
        System.out.println(sock2.getItem());

//        wymazywanie typów Type irassier

    }
}
