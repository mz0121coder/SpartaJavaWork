package com.sparta.mz.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        
        /*
        1. Serialize an ArrayList of Spartans✅
        2. Deserialize an ArrayList of Spartans
        3. Output any of the tasks to an .xml and .json file
         */

        System.out.println("🎉Spartan Jackson Exercise...");
        ArrayList<Spartan> spartanArray = new ArrayList<>();
        Spartan spartanAdam = new Spartan("Adam", "Java", LocalDate.of(2000, 11, 6));
        Spartan spartanTom = new Spartan("Tom", "Java", LocalDate.of(2000, 12, 5));
        Spartan spartanSiyu = new Spartan("Siyu", "Java", LocalDate.of(2000, 10, 4));
        Spartan spartanDJ = new Spartan("DJ", "Java", LocalDate.of(2000, 9, 3));
        Spartan spartanMohammad = new Spartan("Mohammad", "Java", LocalDate.of(2000, 8, 2));
        spartanArray.addAll(Arrays.asList(spartanAdam, spartanTom, spartanSiyu, spartanDJ, spartanMohammad));
        System.out.println(spartanArray);

        ObjectMapper mapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();

        ArrayList<String> spartanJsonFormat = new ArrayList<>();
        ArrayList<String> spartanXMLFormat = new ArrayList<>();
        for (Spartan spartan : spartanArray) {
            try {
                spartanJsonFormat.add(mapper.writeValueAsString(spartan));
                spartanXMLFormat.add(xmlMapper.writeValueAsString(spartan));

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        System.out.println("😎JSON" + spartanJsonFormat.get(0));
        System.out.println("😥XML" + spartanXMLFormat.get(0));


        ArrayList<Spartan> spartanDeserialise = new ArrayList<>();
        for (String spartan : spartanJsonFormat) {
            try {
                spartanDeserialise.add(mapper.readValue(spartan, Spartan.class));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        System.out.println("🥳Spartan Array Deserialise:" + spartanDeserialise.get(0));

        // Output any of the tasks to an .xml and .json file
        Path outputJson = Paths.get("src/main/java/com/sparta/mz/jackson/spartans.json");

        String line;
        for (int i = 0; i < spartanJsonFormat.size(); i++) {
            if (i == 0) {
                line = "[" + spartanJsonFormat.get(i) + ",";
            } else if (i != spartanJsonFormat.size() - 1) {
                line = spartanJsonFormat.get(i) + ",";
            } else {
                line = spartanJsonFormat.get(i) + "]";
            }
            try {
                Files.write(outputJson, (line + "\n").getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}