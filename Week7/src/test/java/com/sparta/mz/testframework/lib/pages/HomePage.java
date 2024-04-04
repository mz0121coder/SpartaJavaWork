package com.sparta.mz.testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver webDriver;
    private final By pastLink = By.linkText("past");
    private final By searchField = new By.ByName("q");
    private final WebDriverWait wait;

    public HomePage(WebDriver webDriver) {
        if (!webDriver.getTitle().equals("Hacker News")) {
            throw new IllegalStateException("This is not the Hacker News home page, current page is: " + webDriver.getCurrentUrl());
        }
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    public PastPage goToPastStoriesPage() {
        webDriver.findElement(pastLink).click();
        return new PastPage(webDriver);
    }

    public JobsPage goToJobsPage() {
       webDriver.findElement(By.linkText("jobs")).click();
       return new JobsPage(webDriver);
    }

    public SearchPage searchFor(String searchTerm){
        webDriver.findElement(searchField).sendKeys(searchTerm, Keys.ENTER);
        System.out.println("SEARCHING");
        return new SearchPage(webDriver);
    }

    public void waitForSearchResults(String text) {
        wait.until(ExpectedConditions.urlContains("/?q=" + text));
    }

    public String getFirstSearchResultText() {
        WebElement firstResult = webDriver.findElement(By.cssSelector(".Story:nth-child(1)"));
        return firstResult.getText().toLowerCase();
    }

    public String getUrl() {
        return this.webDriver.getCurrentUrl();
    }
}
