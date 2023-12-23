Feature: Tests Browser + API + DB integration

  Background:
    Given I print "============================="

#  Scenario: Do something
#    Given I load google page
#    Given I click on GOOGLE_ACCEPT_COOKIES
#    When I set GOOGLE_SEARCH_INPUT value to "Sean Bean"
#    When I click on GOOGLE_LOGO
#    When I click on GOOGLE_SEARCH_BTN
#    Then I see search at least 3 results with text "Sean Bean"

  Scenario Outline: Parametrized scenario
    Given I print <value>
    Given I print <subvalue_1> and <subvalue_2>
    Examples:
      | value | subvalue_1 | subvalue_2 |
      | "A"   | "D"        | "1"        |
      | "B"   | "E"        | "2"        |
      | "C"   | "F"        | "3"        |

#  Scenario Outline: password example
#    Given I set new user password to <pwd>
#    When I click register
#    Then I see error <error>
#    Examples:
#      | pwd               | error                            |
#      | "ab1"             | "Password too short"             |
#      | "abbcccdddeee"    | "Password must contain digits!"  |
#      | "123123123123123" | "Password must contain letters!" |