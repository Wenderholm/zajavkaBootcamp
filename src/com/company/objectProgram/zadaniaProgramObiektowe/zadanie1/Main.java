package com.company.objectProgram.zadaniaProgramObiektowe.zadanie1;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("podaj pierwsza litere wyszukiwanej ksiazki: ");
        String word = sc.nextLine();


        Book book1 = new Book(878234, "Honor nad ziemia", "Jan Kowalski");
        Book book2 = new Book(546879, "Romeo and Juliet", "Wiliam Shakespeare");
        Book book3 = new Book(878554, "King Kong", "Adam Madry");
        Book book4 = new Book(648314, "Hamlet", "Wiliam Shakespeare");
        Book book5 = new Book(112334, "Romeo and Juliet", "Wiliam Shakespeare");
        Book book6 = new Book(213466, "King Kong", "Adam Madry");

        Book[] books = new Book[6];

        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        books[4] = book5;
        books[5] = book6;

        String goodWord = word.toUpperCase(Locale.ROOT);
        int counter = 0;
        for (Book book : books) {
            if(book.getTitle().startsWith(goodWord)){
                counter++;
            }
        }

//        int counter = 0;
//        for (Book book : books) {
//            if (findLetter(book)){
//                counter++;
//            }
//        }

        Book[] onlyChooseTitleArray = new Book[counter];
        int j = 0;
        for (int i = 0; i < books.length; i++) {
            if(books[i].getTitle().startsWith(goodWord)){
                onlyChooseTitleArray[j] = books[i];
                j++;
            }
        }
//
//        for (int i = 0; i < onlyChooseTitleArray.length; i++) {
//            System.out.println(onlyChooseTitleArray[i]);
//        }


        System.out.println();
//        WYŚWIETLENIE ELEMENTÓW TABLICY Z LITERĄ H
        System.out.println("posiadamy w zasobach tyle ksiazek " + counter + " na litere " + word);

        System.out.println("Wykaz ksiazek: ");
        for (Book book : onlyChooseTitleArray) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + " ISBN: " + book.getISBN());
        }


    }
// metoda wyszukująca w którym tytule na pierwszej pozycji znajduje sie H
    private static boolean findLetter(Book book) {
        char[] chars = book.getTitle().toCharArray();
//        System.out.println(Arrays.toString(chars));
        for (char aChar : chars) {
            if (aChar == 'H') {
                return true;
            }
        }
        return false;
    }
}
