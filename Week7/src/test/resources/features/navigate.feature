Feature: As a User, I want to be able to navigate to the Hacker News Website

  Scenario: User navigates to the past page from the Homepage
    Given I am on the Hacker News Homepage
    When I click on the past link
    Then I should be taken to the Past Page

    Scenario: Navigating to the search page using the search text box
      Given I am on the Hacker News Homepage
      When I enter "java" into the Search text box
      Then I will go to the search page with the url parameter "java"


#  Scenario Outline: bad logins with test cases
#    Given I am on the LoginPage
#    When I enter "<username>" into the username box
#    And I enter "<password>" into the password box
#    And I click the login button
#    Then I will see the message "<message>"
#    Examples:
#      | username | password | message |
#      | Cathy    |  £&%!   | Bad login. |
#      | James    |         | Bad login. |
#      |          | password   | Bad login. |



