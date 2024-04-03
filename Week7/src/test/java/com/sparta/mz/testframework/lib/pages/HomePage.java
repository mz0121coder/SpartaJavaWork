package com.sparta.mz.testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver webDriver;

    private final By pastLink = By.linkText("past");
    private final By searchField = new By.ByName("q");

    public HomePage(WebDriver webDriver) {
        if (!webDriver.getTitle().equals("Hacker News")) {
            throw new IllegalStateException("This is not the Hacker News home page, current page is: " + webDriver.getCurrentUrl());
        }
        this.webDriver = webDriver;
    }

    public PastPage goToPastPage() {
        webDriver.findElement(pastLink).click();
        return new PastPage(webDriver);
    }

    public SearchPage search(String searchTerm){
        webDriver.findElement(By.name("q")).sendKeys(searchTerm, Keys.ENTER);
        return new SearchPage(webDriver);
    }
}
