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

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static XmlMapper xmlMapper = new XmlMapper();

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public static XmlMapper getXmlMapper() {
        return xmlMapper;
    }

    public static void main(String[] args) {
        /*
        1. Serialize an ArrayList of Spartans
        2. Deserialize an ArrayList of Spartans
        3. Output any of the tasks to an .xml and .json file
         */

        ArrayList<Spartan> spartanArray = getSpartans();

        // 1. Serialize an ArrayList of Spartans
        ArrayList<String> spartanJsonFormat = new ArrayList<>();
        ArrayList<String> spartanXMLFormat = new ArrayList<>();

        initialiseSpartanJsonAndXMLFormats(spartanArray, spartanJsonFormat, spartanXMLFormat);
        printJsonAndXMLFormats(spartanJsonFormat, spartanXMLFormat);

        // 2. Deserialize an ArrayList of Spartans
        ArrayList<Spartan> spartanDeserialise = new ArrayList<>();

        initialiseSpartanStringFormat(spartanJsonFormat, spartanDeserialise);

        // 3. Output any of the tasks to an .xml and .json file
        Path outputJson = Paths.get("src/main/java/com/sparta/mz/jackson/spartans.json");
        Path outputXML = Paths.get("src/main/java/com/sparta/mz/jackson/spartans.xml");

        writeSpartanToJsonFile(spartanJsonFormat, outputJson);

        writeSpartanToXMLFile(spartanXMLFormat, outputXML);
    }

    private static void printJsonAndXMLFormats(ArrayList<String> spartanJsonFormat, ArrayList<String> spartanXMLFormat) {
        System.out.println(spartanJsonFormat);
        System.out.println(spartanXMLFormat);
    }

    private static void writeSpartanToXMLFile(ArrayList<String> spartanXMLFormat, Path outputXML) {
        String line;
        for (int i = 0; i < spartanXMLFormat.size(); i++) {
            line = spartanXMLFormat.get(i);
            if (i == 0) {
                line = "<Spartans>\n" + spartanXMLFormat.get(i);
            } else if (i == spartanXMLFormat.size() - 1) {
                line = spartanXMLFormat.get(i) + "\n</Spartans>";
            }
            try {
                Files.write(outputXML, (line + "\n").getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void writeSpartanToJsonFile(ArrayList<String> spartanJsonFormat, Path outputJson) {
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

    private static void initialiseSpartanStringFormat(ArrayList<String> spartanJsonFormat, ArrayList<Spartan> spartanDeserialise) {
        for (String spartan : spartanJsonFormat) {
            try {
                spartanDeserialise.add(getObjectMapper().readValue(spartan, Spartan.class));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

    private static void initialiseSpartanJsonAndXMLFormats(ArrayList<Spartan> spartanArray, ArrayList<String> spartanJsonFormat, ArrayList<String> spartanXMLFormat) {
        for (Spartan spartan : spartanArray) {
            try {
                spartanJsonFormat.add(getObjectMapper().writeValueAsString(spartan));
                spartanXMLFormat.add(getXmlMapper().writeValueAsString(spartan));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

    private static ArrayList<Spartan> getSpartans() {
        ArrayList<Spartan> spartanArray = new ArrayList<>();
        Spartan spartanAdam = new Spartan("Adam", "Java", LocalDate.of(2000, 11, 6));
        Spartan spartanTom = new Spartan("Tom", "Java", LocalDate.of(2000, 12, 5));
        Spartan spartanSiyu = new Spartan("Siyu", "Java", LocalDate.of(2000, 10, 4));
        Spartan spartanDJ = new Spartan("DJ", "Java", LocalDate.of(2000, 9, 3));
        Spartan spartanMohammad = new Spartan("Mohammad", "Java", LocalDate.of(2000, 8, 2));
        spartanArray.addAll(Arrays.asList(spartanAdam, spartanTom, spartanSiyu, spartanDJ, spartanMohammad));
        return spartanArray;
    }

}