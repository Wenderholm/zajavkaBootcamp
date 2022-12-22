package com.company._3warsztat.NIO2pathExample;

import java.io.File;
import java.io.IOException;
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

// getFileName() -> metoda zwraca nazwę pliku, jezeli nie ma pliku to zwraca ostatni katalog
        Path path5 = Paths.get("C:/zajavka/someFile.txt");
        Path fileName = path5.getFileName();
        System.out.println(fileName);
        Path path6 = Paths.get("C:/zajavka/someCatalog");
        Path fileName1 = path6.getFileName();
        System.out.println(fileName1);

// getParent()  stworzy nam ścieżkę absolutną na podstawie miejsca, w którym uruchamiany jest projekt w systemie operacyjnym
        Path path7 = Paths.get("C:/zajavka/someFile.txt");
        Path absolutePath = path7.toAbsolutePath();
        System.out.println(absolutePath);
        Path path8 = Paths.get("zajavka/someFile.txt");
        Path absolutePath1 = path8.toAbsolutePath();
        System.out.println(absolutePath1);

// isAbsolute() -> Metoda zwraca boolean mówiący czy podana ścieżka jest absolutna czy nie.
        Path path9 = Paths.get("C:/zajavka/someFile.txt");
        boolean absolute = path9.isAbsolute();
        System.out.println(absolute);
        Path path10 = Paths.get("zajavka/someFile.txt");
        boolean absolute1 = path10.isAbsolute();
        System.out.println(absolute1);

// getRoot() -> Metoda zwraca Path reprezentujący rodzica ostatniego pliku lub katalogu na ścieżce.
        Path path11 = Paths.get("C:/zajavka/someDirectory/someFile.txt");
        Path parent = path11.getParent();
        System.out.println(parent);
        Path path12 = Paths.get("zajavka/someDirectory/someFile.txt");
        Path parent1 = path12.getParent();
        System.out.println(parent1);

// getRoot() -> Pobierz korzeń… Metoda ta zwraca katalog główny (katalog root), czyli katalog nadrzędny dla
// wszystkich innych katalogów. Jeżeli ścieżka jest relatywna, zostanie zwrócony null.
        Path path13 = Paths.get("C:/zajavka/someDirectory/someFile.txt");
        Path root = path13.getRoot();
        System.out.println(root);
        Path path14 = Paths.get("zajavka/someDirectory/someFile.txt");
        Path root1 = path14.getRoot();
        System.out.println(root1);

// subpath() -> Metoda ta analogicznie jak substring() służy do stworzenia podścieżki na podstawie przekazanych
//indeksów ścieżki oryginalnej. Pierwszy argument jest inkluzywny, drugi nieinkluzywny
        System.out.println("subpath()-------------------------------------------------------------");
        Path path15 = Paths.get("C:/zajavka/someDirectory/anotherDirectory/yetAnother/someFile.txt");
        Path subpath1 = path15.subpath(1, 3);
        Path subpath2 = path15.subpath(2, 4);
        Path subpath3 = path15.subpath(0, 2);
        System.out.println(subpath1);
        System.out.println(subpath2);
        System.out.println(subpath3);
        Path path16 = Paths.get("zajavka/someDirectory/anotherDirectory/yetAnother/someFile.txt");
        Path subpath4 = path16.subpath(1, 3);
        Path subpath5 = path16.subpath(2, 4);
        Path subpath6 = path16.subpath(0, 2);
        System.out.println(subpath4);
        System.out.println(subpath5);
        System.out.println(subpath6);

// relativize() -> Metoda ta służy do skonstruowania relatywnej ścieżki ze ścieżki pierwszej do ścieżki drugiej. Innymi
//słowy, efektem jest ścieżka, po której przejściu ze ścieżki pierwszej, znajdziemy się w ścieżce drugiej.
        System.out.println("relativize()-------------------------------------------------------------");
        Path path17 = Paths.get("E:/zajavka/someDirectory/anotherDirectory/yetAnother/someFile.txt");
        Path path18 = Paths.get("E:/zajavka/someDirectory/anotherDirectory/secondDirectory/anotherFile.txt");
        System.out.println(path17.relativize(path18));
        System.out.println(path18.relativize(path17));
        Path path19 = Paths.get("someFile.txt");
        Path path20 = Paths.get("anotherFile.txt");
        System.out.println(path19.relativize(path20));
        System.out.println(path20.relativize(path19));

// resolve() -> A może chcemy dodać do siebie 2 ścieżki? To też tak można. Trzeba tutaj natomiast zwrócić uwagę,
// że ta metoda "nie sprząta" ścieżek. Tzn, że jeżeli na ścieżce występują znaki .., to ta metoda tego nie sprzątnie,
// tylko przeklei dalej tak jak było. Od sprzątania jest następna metoda.
        System.out.println("resolve()-------------------------------------------------------------");
        Path path21 = Paths.get("zajavka/../someDirectory/anotherDirectory");
        Path path22 = Paths.get("secondDirectory/../anotherCatalog");
        System.out.println(path21.resolve(path22));

// normalize() ->Tą metodą możemy posprzątać naszą ścieżkę. Czyli jeżeli na naszej ścieżce występowały .., to
//normalize() skróci tę ścieżkę w taki sposób, aby wynik końcowy był taki sam jak przed wywołaniem tej
//metody, ale zapis będzie krótszy.
        System.out.println("normalize()-------------------------------------------------------------");
        Path path23 = Paths.get("zajavka/../someDirectory/anotherDirectory/secondDirectory/../anotherCatalog");
        System.out.println(path23.normalize());

// toRealPath() -> I ostatnia metoda jaką poruszaliśmy. Ta metoda zachowuje się trochę jak toAbsolutePath(), przy czym
//sprawdza jednocześnie czy plik faktycznie istnieje na dysku. Jeżeli nie istnieje, to wyrzuca znany nam
//już NoSuchFileException.
        Path path24 = Paths.get("/src/com/company/_3warsztat/NIO2pathExample/testPath.txt");
        try {
            System.out.println(path24.toRealPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
