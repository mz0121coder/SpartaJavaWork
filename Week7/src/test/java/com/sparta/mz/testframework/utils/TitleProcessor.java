package com.sparta.mz.testframework.utils;

import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;

public class TitleProcessor {
    public static String getUniqueTitlesAsString(List<WebElement> results) {
        HashSet<String> uniqueTitles = new HashSet<>();

        for (WebElement result : results) {
            String title = result.getText().trim();
            uniqueTitles.add(title);
        }

        return String.join(", ", uniqueTitles);
    }
}
