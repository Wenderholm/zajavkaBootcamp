package com.company.objectProgram.polimorfizm.polimorfizmNaIterfejsie;

public class CardPrinter implements PrinterService{
    @Override
    public void printDocument() {
        System.out.println("Printing card....");
    }
}
