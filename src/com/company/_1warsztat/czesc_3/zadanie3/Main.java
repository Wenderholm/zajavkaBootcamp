package com.company._1warsztat.czesc_3.zadanie3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InvoiceStack invoiceStack = new InvoiceStack();
        Scanner sc = new Scanner(System.in);

        System.out.println("Podaj \"CEO: ADD INVOICE(amount)\" or \"ACCOUNTANT: PROCESS INVOICE\"");

        while(sc.hasNext()){
            String command = sc.nextLine();
            if("EXIT".equals(command)){
                System.out.println("Bye, bye");
                break;
            }
            invoiceStack.process(command);
        }
    }
}
