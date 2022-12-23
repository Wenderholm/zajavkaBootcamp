package com.company._3warsztat.NIO2_paths_files_Example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        paths and files sa to klasy pomocnicze dla path oraz file

        Path path = Paths.get("src/com/company/_3warsztat/NIO2_paths_files_Example/myFiles.txt");
//        sprawdzenie czy dany plik istnieje
//        System.out.println(Files.exists(path));

//  TWORZENIE PLIKU:
//        1. jezeli próbujemy stworzyc plik który już istnieje dostajemy wyjątek
//        2. jeżeli spróbujemy stworzyć katalog pojedyńczy tak jak teraz to zadziała ale jak chceilibysmy stowrzyć
//        someFileExample/someFileExample2 i nie byłoby żadnego z tych dwóch dostaniemy wyjątek NoSuchFileException
//        aby to wykonac musimy wpisac metodę .createDirectories(path3)
        Path path2 = Paths.get("src/com/company/_3warsztat/NIO2_paths_files_Example/someFileExample");
        Path path3 = Paths.get("src/com/company/_3warsztat/NIO2_paths_files_Example/someFileExample1/someFileExample2");
//        try {
//            System.out.println(Files.createDirectory(path2)); // <- dla pojedyńczego katalogu
//            System.out.println(Files.createDirectories(path3)); // <- dla kilku katalogów katalogu
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//  KOPIOWANIE PLIKÓW
        Path path4 = Paths.get("src/com/company/_3warsztat/NIO2_paths_files_Example/myFiles.txt");
        Path path5 = Paths.get("src/com/company/_3warsztat/NIO2_paths_files_Example/myFilesCopied.txt");

//        try {
//            System.out.println(Files.copy(path4,path5));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        PRZENOSZENIE PLIKÓW move - pozwala na przeniesienie pliku i zmianę jego nazwy. wazne jest ze aby przeniesc
//        plik to folder do którego przenisymy musi istnieć.
        Path path6 = Paths.get("src/com/company/_3warsztat/NIO2_paths_files_Example/dir1/file1.txt");
        Path path7 = Paths.get("src/com/company/_3warsztat/NIO2_paths_files_Example/dir2/movedFileFromFile1.txt");

//        try {
//            System.out.println(Files.move(path6,path7));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        USUWANIE PLIKÓW uwsuwanie plików jezeli takie istnieją
        Path path8 = Paths.get("src/com/company/_3warsztat/NIO2_paths_files_Example/dir2/movedFileFromFile1.txt");

//        try {
//            Files.deleteIfExists(path8);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        CZYTANIE PLIKÓW ta metoda czyta caly plik na raz. jezeli użyjemy go bez rozwagi przy dużym pliku to dostaniemy.
//       wyjatek przeciazenie pamieci
        Path path9 = Paths.get("src/com/company/_3warsztat/NIO2_paths_files_Example/dir1/file1.txt");
        try {
            List<String> strings = Files.readAllLines(path9);
            strings.forEach(elem -> System.out.println("Line" +  elem));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
