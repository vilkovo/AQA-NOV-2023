Feature: Integration of API, DB and Selenium

  @severity=critical
  Scenario: Do something critical
    Given I request 1 users from random user service as "CROWD_1"
    Given I store "CROWD_1" users to DB
    And I retrieve a random user from DB as "PERSON_1"
    Given I load google page
    Given I accept cookies if present
    When I set GOOGLE_SEARCH_INPUT value to first last name of "PERSON_1"
    When I click on GOOGLE_LOGO
    When I click on GOOGLE_SEARCH_BTN
    Then I see search at least 3 results with first last name of "PERSON_1"
