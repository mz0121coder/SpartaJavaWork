package com.sparta.mz.testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PastPage {
    private final WebDriver webDriver;

    public PastPage(WebDriver webDriver) {
        if (!webDriver.getTitle().contains("front | Hacker News")) {
            throw new IllegalStateException("This is not the past Page," +
                    " current page is: " + webDriver.getCurrentUrl());
        }
        this.webDriver = webDriver;
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public String getYesterdayDate() {
        WebElement dateElement = webDriver.findElement(By.tagName("font"));
        return dateElement.getText();
    }

    public boolean checkYesterdayDateFormat() {
        return getYesterdayDate().equals(LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

}

