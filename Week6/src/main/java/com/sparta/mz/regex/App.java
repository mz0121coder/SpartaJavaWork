package com.sparta.mz.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        String names = "John,Paul,George,Ringo";
        String[] name = names.split(",");
        System.out.println();

        String input = "John,Paul, George,   Ringo";
        String[] splitStringEither = input.split("[,\\s]+");
        for (int i = 0; i < splitStringEither.length; i++) {
            System.out.println(i + ": " + splitStringEither[i]);
        }

        String email = "mgadhvi@spartaglobal.com";
        Pattern emailPattern = Pattern.compile("[a-z.]+@[a-z.]+");
        Matcher emailMatcher = emailPattern.matcher(email);
        System.out.println(emailMatcher.find());

        System.out.println(email.matches("^[A-Za-z]+@[A-Za-z]+\\.com+$"));

        // Match a UK PostCode
        String postCodeOne = "NE3 3HY";
        String postCodeTwo = "B1 8NE";
        String postCodeThree = "BT22 1JP";
        String postCodeFour = "SE1P 5LX";

        String[] postCodeArr = {postCodeOne, postCodeTwo, postCodeThree, postCodeFour};

        Pattern postCodePattern = Pattern.compile("[A-Z]{1,2}\\d[A-Z\\d]{0,1}\\s\\d[A-Z]{2}");

        for (String postCode : postCodeArr) {
            Matcher postCodeMatcher = postCodePattern.matcher(postCode);
            System.out.println(postCodeMatcher.find());
        }
    }
}
