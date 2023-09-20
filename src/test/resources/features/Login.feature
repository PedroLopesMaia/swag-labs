@login @regression

Feature:Swag Labs - Login

  Background:
    Given I access the login page

  Scenario: Validate Unsuccessful Login - Empty fields
    When I click the login button
    And I am presented with a empty fields error message
    Then I should be able to click on the error message close button

  Scenario: Validate Locked Out User
    When I enter a blocked username
    And I enter the correct password
    And I click the login button
    And I am presented with a blocked user error message
    Then I should be able to click on the error message close button

  Scenario Outline: Validate - Successful Login
    When I enter a username <username>
    And I enter a password <password>
    And I click the login button
    Then I should be presented with the main page
    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  Scenario Outline: Validate - Unsuccessful Login
    When I enter a username <username>
    And I enter a password <password>
    And I click the login button
    And I am presented with a wrong credentials error message
    Then I should be able to click on the error message close button

    Examples:
      | username      | password     |
      | usuario       | secret_sauce |
      | standard_user | senha_errada |
      | usuario       | senha_errada |