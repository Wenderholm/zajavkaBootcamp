package com.company._3warsztat.klasaFile;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("someFile.txt");
        File file2 = new File("./src/com/company/_3warsztat/klasaFile/nowy.txt");
        System.out.println(file.exists());
        System.out.println(file2.exists());

        if(!file.exists()){
            System.out.println("File " + file + " not available");
        }
// scieżka absolutna do podanego pliku
        System.out.println(file.getAbsolutePath());
// scieżka do rodzica podanego pliku
        System.out.println(file2.getParent());

        if(file.isFile()){
            System.out.println("File " + file + " is file");
            System.out.println("File.length(): " + file.length());
        }

        File file3 = new File("./src/com/company/_3warsztat/klasaFile");
        if(file3.isDirectory()){
            System.out.println("File " + file3 + " is directory");
            for (File listFile : file3.listFiles()) {
                System.out.println("Subfile " + listFile);
            }
        }
        System.out.println(file3.lastModified());

//        file3.delete() <- usunięcie pliku

        file3.renameTo(new File("nowy11.txt"));
    }
}
