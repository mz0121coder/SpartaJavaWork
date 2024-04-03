package com.sparta.mz.testframework;

import com.sparta.mz.testframework.lib.pages.HomePage;
import com.sparta.mz.testframework.lib.pages.LoginPage;
import com.sparta.mz.testframework.lib.pages.PastPage;
import com.sparta.mz.testframework.lib.pages.SearchPage;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v85.log.Log;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.hamcrest.Matchers.*;

public class HackerNewsPomTests {
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver-mac-arm64/chromedriver";

    private static final String BASE_URL = "https://news.ycombinator.com/";
    private static final String PAST_STORIES_URL = "https://news.ycombinator.com/front";

    private static ChromeDriverService service;

    private WebDriver webDriver;

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
//        options.setImplicitWaitTimeout(Duration.ofSeconds(10));
        return options;
    }

    @BeforeAll
    public static void beforeAll() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(DRIVER_LOCATION))
                .usingAnyFreePort()
                .build();
        service.start();
    }

    @BeforeEach
    public void setup() {
        webDriver = new RemoteWebDriver(service.getUrl(), getChromeOptions());
//        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void afterEach() {
        webDriver.quit();
    }

    @AfterAll
    static void afterAll() {
        service.stop();
    }

    @Test
    @DisplayName("Check that the webdriver works")
    public void checkWebDriver() {
        webDriver.get(BASE_URL);
        Assertions.assertEquals("https://news.ycombinator.com/", webDriver.getCurrentUrl());
        Assertions.assertEquals("Hacker News", webDriver.getTitle());
    }

    @Test
    @DisplayName("Check that the link to the past page works")
    public void checkPastLink() {
        // Arrange
        webDriver.get(BASE_URL);
        HomePage homePage = new HomePage(webDriver);
        // Act
        PastPage pastPage = homePage.goToPastStoriesPage();
        // Assert
        MatcherAssert.assertThat(pastPage.getUrl(), is("https://news.ycombinator.com/front"));
        MatcherAssert.assertThat(pastPage.getTitle(), containsString("front"));
    }

    @Test
    @DisplayName("Check that the link to the comments page works")
    public void checkCommentLink() {
        // Arrange
        webDriver.get(BASE_URL);
        // Act
        WebElement commentsLink = webDriver.findElement(By.linkText("comments"));
        commentsLink.click();
        // Assert
        MatcherAssert.assertThat(webDriver.getCurrentUrl(), is("https://news.ycombinator.com/newcomments"));
        MatcherAssert.assertThat(webDriver.getTitle(), containsString("New Comments"));
    }

    @Test
    @DisplayName("Check that the link to the login page works")
    public void checkLoginLink() {
        // Arrange
        webDriver.get(BASE_URL);
        // Act
        WebElement loginLink = webDriver.findElement(By.linkText("login"));
        loginLink.click();
        // Assert
        MatcherAssert.assertThat(webDriver.getCurrentUrl(), is("https://news.ycombinator.com/login?goto=news"));
        MatcherAssert.assertThat(webDriver.getTitle(), containsString(""));
    }

    @Test
    @DisplayName("Check that the link to the jobs page works")
    public void checkJobsLink() {
        // Arrange
        webDriver.get(BASE_URL);
        // Act
        WebElement jobsLink = webDriver.findElement(By.linkText("jobs"));
        jobsLink.click();
        // Assert
        MatcherAssert.assertThat(webDriver.getCurrentUrl(), is("https://news.ycombinator.com/jobs"));
        MatcherAssert.assertThat(webDriver.getTitle(), containsString("jobs"));
    }

    @Test
    @DisplayName("Check that we can search for java")
    void searchForJava() {
        // Arrange
        webDriver.get(BASE_URL);
        HomePage homePage = new HomePage(webDriver);
        // Act
        SearchPage searchPage = homePage.searchFor("java");
        // Assert
        MatcherAssert.assertThat(searchPage.getUrl(), is("https://hn.algolia.com/?q=java"));
    }

    @Test
    @DisplayName("Check that we can use search facility with wait")
    void searchForJavaWithWait() {
//        Arrange
        webDriver.get(BASE_URL);
        HomePage homePage = new HomePage(webDriver);
//        Act
        homePage.searchFor("Java");
        homePage.waitForSearchResults("Java");
//        Assert
        MatcherAssert.assertThat(homePage.getFirstSearchResultText(),containsString("java"));
    }

    @Test
    @DisplayName("Check that the date for yesterday's stories is correct")
    public void checkPastDateFormatIsCorrect() {
//        Arrange
        webDriver.get(PAST_STORIES_URL);
        PastPage pastPage = new PastPage(webDriver);
//        Assert
        MatcherAssert.assertThat(pastPage.checkYesterdayDateFormat(), is(true));
    }

    @Test
    @DisplayName("Attempt invalid login")
    void invalidLoginTest() {
//        Arrange
        webDriver.get(BASE_URL);
        LoginPage loginPage = new LoginPage(webDriver);
//        Act
        loginPage.openLoginPage();
        loginPage.enterUsername("Cathy");
        loginPage.enterPassword("£&%!");
        loginPage.submitLoginForm();
//        Assert
        MatcherAssert.assertThat(loginPage.isErrorMessageDisplayed(),is(true));
    }

    @Test
    void checkNumberOfSearchResultsPerPageIs30() {
//        Arrange
        webDriver.get(BASE_URL);
        HomePage homePage = new HomePage(webDriver);
//        Act
        SearchPage searchPage = homePage.searchFor("java");
//        Assert
        int numberOfResults = searchPage.getNumberOfResults();
        MatcherAssert.assertThat(numberOfResults, lessThanOrEqualTo(30));
    }
}
