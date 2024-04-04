package com.sparta.mz.testframework.lib.pages;

import com.sparta.mz.testframework.utils.TitleProcessor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class JobsPage {
    private final WebDriver webDriver;

    public JobsPage(WebDriver webDriver) {
        if (!webDriver.getTitle().contains("jobs | Hacker News")) {
            throw new IllegalStateException("This is not the jobs Page," +
                    " current page is: " + webDriver.getCurrentUrl());
        }
        this.webDriver = webDriver;
    }

    public String getUrl() {
        return this.webDriver.getCurrentUrl();
    }

    public String getTitle() {
        return this.webDriver.getTitle();
    }

    public int getNumberOfResults() {
        List<WebElement> results = webDriver.findElements(By.className("titleline"));
        return results.size();
    }

    public String viewJobArticleTitles() {
        List<WebElement> results = webDriver.findElements(By.className("titleline"));
        return TitleProcessor.getUniqueTitlesAsString(results);
    }

    public void viewMoreJobs() {
        webDriver.findElement(By.className("morelink")).click();
    }
}
