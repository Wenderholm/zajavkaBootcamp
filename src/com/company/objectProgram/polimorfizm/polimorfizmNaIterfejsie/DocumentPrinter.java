package com.company.objectProgram.polimorfizm.polimorfizmNaIterfejsie;

public class DocumentPrinter implements PrinterService{

    @Override
    public void printDocument() {
        System.out.println("Printing document....");
    }
}
