package com.company.wyjatkiTryCatch.exceptionRunTimeException;

public class Main {
    public static void main(String[] args) {
//        System.out.println(8/0);

//        exception

// stackTrace z wyjątku możemy kopiować i wrzucić do Analyze pozniej Stack Trace or thread dump

//        try {
// w bloku try wykona sie tylko jedna metoda exceptionMethod() po tym zostanie to przerwane i wyrzuci wyjatek
//            exceptionMethod();
//            System.out.println("middle information");
//            exceptionMethod();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        Driver andrzej = new Driver(36);
        Driver ryszard = new Driver(36);

        try {
            andrzej.setAge(37);
            ryszard.setAge(17);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

//
//    public static void exceptionMethod() throws Exception {
//        throw new Exception("my exception message");
//    }

}
