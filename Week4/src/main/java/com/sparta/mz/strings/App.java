package com.sparta.mz.strings;
import java.lang.StringBuilder;

public class App {
    public static void main(String[] args) {
//        String name = "Mohammad";
//        String name1 = "Mohammad";
//        String name2 = "Mohammad";
//
//        System.out.println(name.hashCode());
//        System.out.println(name1.hashCode());
//        System.out.println(name2.hashCode());
//        System.out.println(isPalindrome("racecar"));
        System.out.println(isPalindrome("nonpalindrome"));
    }

    static boolean isPalindrome(String input){
        return new StringBuilder(input).reverse().toString().equals(input);
    }

}
