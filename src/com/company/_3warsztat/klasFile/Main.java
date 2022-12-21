package com.company._3warsztat.klasFile;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("someFile.txt");
        File file2 = new File("./src/com/company/_3warsztat/klasFile/nowy.txt");

        System.out.println(file.exists());
        System.out.println(file2.exists());

        if(!file.exists()){
            System.out.println("File: " + file + " not available");
        }

        System.out.println(file.getAbsolutePath());
        System.out.println(file2.getParent());

        if(file.isFile()){
            System.out.println("File: " + file + " is file");
            System.out.println("File.length(): " + file.length());
        }

        File file3 = new File("./src/com/company/_3warsztat/klasFile");
        if(file3.isDirectory()){
            for (File listFile : file3.listFiles()) {
                System.out.println("Subfile: " + listFile);
            }
        }
//      tworzy nowy folder bez zagnieżdżeń
        File file4 = new File("someFolder");
        System.out.println("File file.mkdir(): " + file4.mkdir());
//      tworzy nowy folder z zagnieżdzeniami
        File file5 = new File("someFolder/a/b/c");
        System.out.println("File file.mkdirs(): " + file5.mkdirs());

    }
}
