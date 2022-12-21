package com.company._3warsztat.code;

import java.nio.file.Path;
import java.nio.file.Paths;

public class SupressedExceptionsExample {
    public static void main(String[] args) {
        try(Door door = new Door()){
            System.out.println("Opening the Door!");
        }
        catch (Exception e) {
            System.out.println("Handling door exception: " + e.getMessage());
        }finally {
            System.out.println("Calling finally");
        }
    }
    static class Door implements AutoCloseable{
        public Door() {
            System.out.println("Calling Door constructor");
        }

        @Override
        public void close() throws Exception {
            System.out.println("callong close()");
        }
    }
}


