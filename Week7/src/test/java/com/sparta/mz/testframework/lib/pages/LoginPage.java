package com.sparta.mz.testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void openLoginPage() {
        webDriver.get("https://news.ycombinator.com/login");
    }

    public void enterUsername(String username){
        WebElement usernameInput = webDriver.findElement(By.name("acct"));
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = webDriver.findElement(By.name("pw"));
        passwordInput.sendKeys(password);
    }

    public void submitLoginForm() {
        webDriver.findElement(By.cssSelector("input[value='login']")).click();
    }

    public boolean isErrorMessageDisplayed() {
        return webDriver.findElement(By.tagName("body")).getText().contains("Bad login.");
    }
}
