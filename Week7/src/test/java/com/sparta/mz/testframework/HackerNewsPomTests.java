package com.sparta.mz.testframework;

import com.sparta.mz.testframework.lib.pages.HomePage;
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
import org.openqa.selenium.remote.RemoteWebDriver;
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
        PastPage pastPage = homePage.goToPastPage();
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

//    @Test
//    @DisplayName("Check that we can search for java")
//    void searchForJava() {
//        // Arrange
//        webDriver.get(BASE_URL);
//        // Act
//        webDriver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
//        // Assert
//        MatcherAssert.assertThat(webDriver.getCurrentUrl(), is("https://hn.algolia.com/?q=java"));
//    }

    @Test
    @DisplayName("Check that we can search for java")
    void searchForJava() {
        // Arrange
        webDriver.get(BASE_URL);
        HomePage homePage = new HomePage(webDriver);
        // Act
        SearchPage searchPage = homePage.search("java");
        // Assert
        MatcherAssert.assertThat(searchPage.getUrl(), is("https://hn.algolia.com/?q=java"));
    }

    @Test
    @DisplayName("Check that we can use search facility with wait")
    void searchForJavaWithWait() {
         Wait<WebDriver> webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        webDriver.get(BASE_URL);

        webDriver.findElement(By.name("q"))
                .sendKeys("Java", Keys.ENTER);

         webDriverWait.until(driver -> driver.getCurrentUrl().contains("/?q=Java"));

        MatcherAssert.assertThat(
                webDriver.findElement(By.cssSelector(".Story:nth-child(1)"))
                        .getText()
                        .toLowerCase(),
                containsString("java")
        );
    }

    @Test
    @DisplayName("Check that the date for yesterday's stories is correct")
    public void checkPastDateFormatIsCorrect() {
        // Arrange
        webDriver.get(BASE_URL);
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String yesterdayFormatted = yesterday.format(formatter);

        // Act
        WebElement pastLink = webDriver.findElement(By.linkText("past"));
        pastLink.click();

        // Assert
        MatcherAssert.assertThat(webDriver.getCurrentUrl(), is("https://news.ycombinator.com/front"));
        MatcherAssert.assertThat(webDriver.findElement(By.tagName("font")).getText(), is(yesterdayFormatted));
    }

//    Philip's test
//    @Test
//    @DisplayName("Check that the past page has yesterday's date")
//    void checkYesterdayDay() {
//        Wait<WebDriver> wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
//
//        webDriver.get(BASE_URL);
//
//        WebElement pastLink = wait.until(p -> p.findElement(By.linkText("past")));
//        pastLink.click();
//
//        LocalDate yesterday = LocalDate.now().minusDays(1);
//
//        wait.until(d -> d.getCurrentUrl().contains("front"));
//        String topString = webDriver.findElement(By.className("pagetop")).getText();
//
//        MatcherAssert.assertThat(topString, containsString(yesterday.toString()));
//    }

//    @Test
//    @DisplayName("Check that each story from yesterday is created no more than 1 day ago")
//    public void checkPastStoriesCreationDate() {
////        Arrange
//        webDriver.get(BASE_URL);
//        Pattern createdPattern = Pattern.compile("1 day ago|\\d{1,2} hours ago");
////        Act
//        WebElement pastLink = webDriver.findElement(By.linkText("past"));
//        pastLink.click();
//        Wait<WebDriver> webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
////        Assert
//        MatcherAssert.assertThat(webDriver.getCurrentUrl(), is("https://news.ycombinator.com/front"));
//
//        List<WebElement> elements = webDriver.findElements(By.className("subtext a:link"));
//        webDriverWait.until(elements.toString(), is(not("")));
//        MatcherAssert.assertThat(elements.stream().map(WebElement::getText).allMatch(text -> createdPattern.matcher(text).matches()), CoreMatchers.is(true));
//    }

    @Test
    @DisplayName("Attempt invalid login")
    void invalidLoginTest() {
        Wait<WebDriver> wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriver.get("https://news.ycombinator.com/login");

        WebElement userNameBox = wait.until(p -> p.findElement(By.name("acct")));
        userNameBox.sendKeys("Cathy");

        WebElement passwordInput = webDriver.findElement(By.name("pw"));
        // Alternative way of finding passwordInput using RelativeLocator
        // WebElement passwordInput = webDriver.findElement(
        //         RelativeLocator.with(By.tagName("input"))
        //                       .below(userNameBox));
        passwordInput.sendKeys("£&%!");

        webDriver.findElement(By.cssSelector("input[value='login']")).click();

        MatcherAssert.assertThat(
                wait.until(p -> p.findElement(By.tagName("body")).getText().contains("Bad login.")),
                is(true)
        );
    }

    @Test
    void checkNumberOfSearchResultsPerPageIs30() {
        Wait<WebDriver> webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        webDriver.get(BASE_URL);

        webDriver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);

        webDriverWait.until(d -> d.getCurrentUrl().contains("q=java"));
        List<WebElement> results = webDriver.findElements(By.className("Story"));

        MatcherAssert.assertThat(results.size(), lessThanOrEqualTo(30));
    }
}
