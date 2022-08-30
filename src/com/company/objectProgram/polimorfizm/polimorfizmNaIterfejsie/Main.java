package com.company.objectProgram.polimorfizm.polimorfizmNaIterfejsie;

public class Main {

    public static void main(String[] args) {
        PrinterService docPrint = new DocumentPrinter();
        PrinterService cardPrint = new CardPrinter();
        PrinterService imgPrint = new ImagePrinter();


        docPrint.printDocument();
        cardPrint.printDocument();
        imgPrint.printDocument();
    }
}
