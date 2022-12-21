package com.company._3warsztat.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TryWithResource {
    public static void main(String[] args) {
        example(Paths.get("someFile.txt"), Paths.get("otherSomeFile.txt"));
    }
    public static void example(final Path path1, final Path path2){
        try(
            BufferedReader in = Files.newBufferedReader(path1);
            BufferedWriter out  = Files.newBufferedWriter(path2)
        ){
            String line = in.readLine();
            out.write(line);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
