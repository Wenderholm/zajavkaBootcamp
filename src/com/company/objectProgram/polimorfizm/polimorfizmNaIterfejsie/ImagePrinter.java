package com.company.objectProgram.polimorfizm.polimorfizmNaIterfejsie;

public class ImagePrinter implements PrinterService{
    @Override
    public void printDocument() {
        System.out.println("Printing image....");
    }
}
