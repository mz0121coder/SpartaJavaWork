package com.sparta.mz.testframework.lib.pages;

import org.openqa.selenium.WebDriver;

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
}
