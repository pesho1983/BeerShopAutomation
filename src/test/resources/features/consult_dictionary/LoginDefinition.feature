Feature: Login Functionality
  In order to purchase beers
  As a customer
  I want to be able to login

  Scenario Outline: Login with valid data
    Given I am on Login page
    When I enter valid <username> and <password>
    And Click on Sign In button
    Then I should be logged in
    Examples:
      | username | password    |
      | admin1   | parola123A! |
      | admin2   | parola123!A |

  Scenario Outline: Login with invalid data
    Given I am on Login page
    When I enter invalid <username> and <password>
    And Click on Sign In button
    Then I should see "Wrong username or password!" message
    Examples:
      | username | password    |
      | admi     | parola123A! |
      | admin2   | ola123!A    |

  Scenario Outline: Check fields validations with empty data
    Given I am on Login page
    When I enter invalid <username> and <password>
    And Click on Sign In button
    Then I should see "This field is required." <validation> message
    Examples:
      | username | password    | validation |
      |          | parola123A! | 0          |
      | admin2   |             | 1          |
      |          |             | 2          |