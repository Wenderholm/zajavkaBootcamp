package com.company.objectProgram.polimorfizm.polimorfizmNaKlasach;

public class Start {
    public static void main(String[] args) {
        DocumentItem wordItem = new WordDocument();
        DocumentItem excelItem = new ExcelDocument();
        DocumentItem pdfItem = new PdfDocument();

        WordDocument wordItem2 = new WordDocument();


        System.out.println(wordItem.getDescription());
//        nie działa z typem referencji DocumentItem bo w klasie DocumentItem nie ma metody wordMethod()
//        System.out.println(wordItem.wordMethod());
        System.out.println(wordItem2.wordMethod());

        System.out.println(excelItem.getDescription());
        System.out.println(pdfItem.getDescription());
    }
}
