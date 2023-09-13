@login @regression

Feature:Swag Labs - Login

  Background:
    Given I access the login page

  Scenario: Validate Successful Login - Correct password
    When I enter the correct username
    And I enter the correct password
    And I click the login button
    Then I should be presented with the main page