Feature: As a User, I want to be able to browse jobs on the Hacker News Website

  Scenario: User navigates to the jobs page from the Homepage
    Given I am on the Hacker News Homepage
    When I click on the jobs link
    Then I should be taken to the Jobs Page

  Scenario: User is shown up to 30 jobs on the jobs page
    Given I am on the Hacker News Homepage
    When I click on the jobs link
    Then There should be up to 30 jobs articles displayed

  Scenario: User clicks to see more jobs and is shown the next 30
    Given I am on the Hacker News Homepage
    When I click on the jobs link
    And I select the button to view more jobs
    Then There should be a new set of jobs displayed
    And The url should end in '/jobs?next=' + 8 digits

  Scenario: User goes back to page 1 of jobs articles and is shown the original set
    Given I am on the Hacker News Homepage
    When I click on the jobs link
    And I select the button to view more jobs
    Then There should be a new set of jobs displayed
    And I go back to the first page of jobs articles
    Then I see the original set and the url has changed

