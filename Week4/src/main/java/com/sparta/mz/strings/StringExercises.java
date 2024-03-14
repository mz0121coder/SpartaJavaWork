package com.sparta.mz.strings;

import java.text.DecimalFormat;

public class StringExercises {
    public static String manipulateStringUsingStringBuilder(String original, int num) {
        StringBuilder sb = new StringBuilder(original.toUpperCase().trim());
        for (int i = 0; i < num; i++) {
            sb.append(Integer.toString(i));
        }
        return sb.toString();
    }

    public static String address(int num, String street, String city, String postCode) {
        return STR."\{num} \{street}, \{city} \{postCode}.";
    }

    public static String scorer(int score, int outOf) {
        double percent = ((double) score / outOf) * 100;
        DecimalFormat decimalFormat = new DecimalFormat("0.#");

        return STR."You got \{score} out of \{outOf}: \{decimalFormat.format(percent)}%";
    }
}
