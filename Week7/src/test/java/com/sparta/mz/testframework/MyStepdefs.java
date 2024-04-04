package com.sparta.mz.testframework;

import com.sparta.mz.testframework.lib.pages.HomePage;
import com.sparta.mz.testframework.lib.pages.JobsPage;
import com.sparta.mz.testframework.lib.pages.PastPage;
import com.sparta.mz.testframework.lib.pages.SearchPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.Matchers.*;

public class MyStepdefs {
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver-mac-arm64/chromedriver";
    private static final String BASE_URL = "https://news.ycombinator.com/";
    private static final String PAST_STORIES_URL = "https://news.ycombinator.com/front";

    private static ChromeDriverService service;
    private WebDriver webDriver;
    private HomePage homePage;
    private PastPage pastPage;
    private SearchPage searchPage;
    private JobsPage jobsPage;
    private String jobArticleTitlesPage1 = "this is updated in the 'iClickOnTheJobsLink' test";

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized");
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

    @Before
    public void setup() {
        webDriver = new RemoteWebDriver(service.getUrl(), getChromeOptions());
    }

    @After
    public void afterEach() {
        webDriver.quit();
    }

    @AfterAll
    static void afterAll() {
        service.stop();
    }

    @Given("I am on the Hacker News Homepage")
    public void iAmOnTheHackerNewsHomepage() {
        webDriver.get(BASE_URL);
        homePage = new HomePage(webDriver);
    }

    @When("I click on the past link")
    public void iClickOnThePastLink() {
        pastPage = homePage.goToPastStoriesPage();
    }

    @Then("I should be taken to the Past Page")
    public void iShouldBeTakenToThePastPage() {
        MatcherAssert.assertThat(pastPage.getUrl(), org.hamcrest.Matchers.is(PAST_STORIES_URL));
    }

    @When("I enter {string} into the Search text box")
    public void iEnterIntoTheSearchTextBox(String text) {
        searchPage = homePage.searchFor("java");
        homePage.waitForSearchResults("java");
    }

    @Then("I will go to the search page with the url parameter {string}")
    public void iWillGoToTheSearchPageWithTheUrlParameter(String text) {
        MatcherAssert.assertThat(searchPage.getUrl(), is("https://hn.algolia.com/?q=java"));
    }

    @When("I click on the jobs link")
    public void iClickOnTheJobsLink() {
        jobsPage = homePage.goToJobsPage();
        jobArticleTitlesPage1 = jobsPage.viewJobArticleTitles();
    }

    @Then("I should be taken to the Jobs Page")
    public void iShouldBeTakenToTheJobsPage() {
        MatcherAssert.assertThat(jobsPage.getUrl(), endsWith("/jobs"));
        MatcherAssert.assertThat(jobsPage.getTitle(), containsString("jobs"));
    }

    @Then("There should be up to {int} jobs articles displayed")
    public void thereShouldBeUpToJobsDisplayed(int numberOfJobs) {
        MatcherAssert.assertThat(jobsPage.getNumberOfResults() <= 30, is(true));
    }

    @And("The url should be {string}")
    public void theUrlShouldBeHttpsNewsYcombinatorComJobs() {
        MatcherAssert.assertThat(jobsPage.getUrl(), is("https://news.ycombinator.com/jobs"));
    }

    @And("I select the button to view more jobs")
    public void iSelectTheButtonToViewMoreJobs() {
        jobsPage.viewMoreJobs();
    }

    @Then("There should be a new set of jobs displayed")
    public void thereShouldBeANewSetOfJobsDisplayed() {
        String jobArticleTitlesPage2 = jobsPage.viewJobArticleTitles();
        MatcherAssert.assertThat(jobArticleTitlesPage1.equals(jobArticleTitlesPage2), is(false));
    }

    @And("The url should end in {string} + {int} digits")
    public void theUrlShouldEndInJobsNextDigits(String str, int arg0) {
        Pattern urlEnd = Pattern.compile("/jobs\\?next=\\d{8}$");
        Matcher matcher = urlEnd.matcher(jobsPage.getUrl());
        MatcherAssert.assertThat(matcher.find(), is(true));
    }

    @And("I go back to the first page of jobs articles")
    public void iGoBackToTheFirstPageOfJobsArticles() {
        webDriver.navigate().back();
    }

    @Then("I see the original set and the url has changed")
    public void iSeeTheOriginalSetAndTheUrlHasChanged() {
        MatcherAssert.assertThat(jobsPage.viewJobArticleTitles().equals(jobArticleTitlesPage1), is(true));
        MatcherAssert.assertThat(jobsPage.getUrl(), is("https://news.ycombinator.com/jobs"));
    }

}
