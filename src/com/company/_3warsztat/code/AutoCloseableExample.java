package com.company._3warsztat.code;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AutoCloseableExample {
    public static void main(String[] args) {
        example(Paths.get("someFile.txt"), Paths.get("otherSomeFile.txt"));
    }
    public static void example(final Path path1, final Path path2){
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
