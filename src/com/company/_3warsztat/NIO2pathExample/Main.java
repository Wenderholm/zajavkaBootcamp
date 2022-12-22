package com.company._3warsztat.NIO2pathExample;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws URISyntaxException {

        File file = new File("./src/com/company/_3warsztat/NIO2pathExample/testFile.txt");
        Path path = Paths.get("./src/com/company/_3warsztat/NIO2pathExample/testPath.txt");
//        tworzenie path z użyciem URI - potrzebuje podania rodzaju zasobu np. file:// , ftp:// , https://
//        Paths.get(new URI("ftp:/"));
//       tworazenie za pomoca fileSystem
        FileSystem fileSystem = FileSystems.getDefault();
        fileSystem.getPath("./zajavka/pl/zajavka");
//        to samo co powyzej tylko bez slash
        fileSystem.getPath("zajavka","pl","zajavka");

//        zamiana file na path i odwrotnie
        Path path1 = file.toPath();
        File file1 = path.toFile();

//  toString() -> zamiana path na string
        Path path2 = Paths.get("C:/zajavka/someFile.txt");
        String toString = path2.toString();
        System.out.println(toString);

//  getNameCount() -> zlicza nam ilość folderów w danej scieżce
        Path path3 = Paths.get("C:/zajavka/someFile.txt");
        int nameCount = path3.getNameCount();
        System.out.println(nameCount);

// getName(int index) -> zwraca nam obiekt typu path na danym indeksie. indeks liczony od 0 ale pomijany jest root
        Path path4 = Paths.get("C:/innyFolder/zajavka/someFile.txt");
        Path name0 = path4.getName(0);
        System.out.println(name0);

// getFileName() -> metoda zwraca nazwę pliku
// getParent()
// getRoot()
// subpath()
// relativize()
// resolve()
// normalize()
// toRealPath()

    }
}
