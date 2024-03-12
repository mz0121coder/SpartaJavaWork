package com.sparta.mz.basics;

public class FilmClassification {

    public static String getClassificationsByAge(int ageOfViewer)
    {
        String result;
        if(ageOfViewer < 0) {
            result = "Invalid age.";
        } else if(ageOfViewer < 12) {
            result = "U & PG films are available.";
        } else if (ageOfViewer < 15) {
            result = "U, PG & 12 films are available.";
        } else if (ageOfViewer < 18) {
            result = "U, PG, & 12 and 15 films are available.";
        } else {
            result = "All films are available.";
        }
        return result;
    }
}

