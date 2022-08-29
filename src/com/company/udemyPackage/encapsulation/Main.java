package com.company.udemyPackage.encapsulation;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer(50,false);
        System.out.println("initial pages count = " + printer.getPagesPrinted());
        int pagesPrinter = printer.printPages(4);
        System.out.println("pages printed was " + pagesPrinter + ". now total print count is " + printer.getPagesPrinted());
        pagesPrinter = printer.printPages(71);
        System.out.println("pages printed was " + pagesPrinter + ". now total print count is " + printer.getPagesPrinted());
    }
}
