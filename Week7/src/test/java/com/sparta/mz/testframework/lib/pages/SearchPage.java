package com.sparta.mz.testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {
    private final WebDriver webDriver;

    public SearchPage(WebDriver webDriver) {
        if (!webDriver.getTitle().contains("All | Search powered by Algolia")) {
            throw new IllegalStateException("This is not the search Page," +
                    " current page is: " + webDriver.getCurrentUrl());
        }        this.webDriver = webDriver;
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }
    public int getNumberOfResults(){
        List<WebElement> results = webDriver.findElements(By.className("Story"));
        return results.size();
    }
}
