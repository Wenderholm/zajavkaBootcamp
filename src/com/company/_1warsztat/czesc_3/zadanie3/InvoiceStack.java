package com.company._1warsztat.czesc_3.zadanie3;

import java.math.BigDecimal;
import java.time.Year;
import java.util.ArrayDeque;
import java.util.Deque;

public class InvoiceStack {
    Integer counter = 1;
    Deque<Invoice> invoiceStack = new ArrayDeque<>();

    public void process(String command) {
        if(command.contains("CEO: ADD INVOICE")){
//            System.out.println("działa ceo");
            processCEOInput(command);

        }else if(command.contains("ACCOUNTANT: PROCESS INVOICE")){
//            System.out.println("działa accountant");
            processAccountantInput(command);
        }else{
            System.out.println("o co ci chodzi");
        }
    }

    private void processCEOInput(String command) {
//        wyciecie liczby z podanego ciagu znaków
        BigDecimal amount = new BigDecimal(command.substring(command.indexOf("(") + 1, command.indexOf(")")));
//        System.out.println("wyciecie " + amount);
        Integer year = Year.now().getValue();
        String id = counter + "/" + year;
        counter++;
// tworzenie faktury
        Invoice invoice = new Invoice(id, amount);
//        dodawanie faktury do kolejki
        invoiceStack.push(invoice);


//        Samouczek Programisty istnieje od %d roku. Wszystkie artykuły pisze %s.", 2015, "Marcin"
        System.out.printf("%s%n", command);
        System.out.printf("CEO added invoice: ID: %s, amount: %s%n", id, amount);
        System.out.printf("Current invoices total amount: %s. Invoices: [{ID: %s, AMOUNT: %s}]%n", getInvoiceSum(), id, amount);

    }

    private void processAccountantInput(String command) {
        System.out.printf("%s%n", command);

        if(invoiceStack.isEmpty()){
            System.out.println("Stack is empty. no work for accountant");
            return;
        }
//      wyciagniecie faktury z kolejki z jej wypisaniem
        Invoice invoice = invoiceStack.pop();
//        System.out.println(invoice);
        System.out.printf("ACCOUNTANT PROCESSED INVOICE: %s%n", invoice);
        System.out.printf("Current invoices amount %s. Invoices: %s%n", getInvoiceSum(), invoiceStack);
    }


//    obliczenia sumy faktur z uzyciem BigDecimal
    private String getInvoiceSum() {
        BigDecimal sum = BigDecimal.ZERO;
        for (Invoice invoice : invoiceStack) {
            sum = sum.add(invoice.getAmount());
        }
        return sum.toString();
    }

    
}
