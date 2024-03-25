package com.sparta.mz.fileio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class App {
    public static void main(String[] args) {
        Path input = Paths.get("src/main/java/com/sparta/mz/fileio/input.txt");
        Path output = Paths.get("src/main/java/com/sparta/mz/fileio/output.txt");

        try (BufferedReader reader = Files.newBufferedReader(input)) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
//                System.out.println(line);
                Files.write(output, (line + "\n").getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            System.out.println("File has not been found");
        }
    }
}
