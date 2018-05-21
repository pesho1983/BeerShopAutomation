Feature: Login Functionality
  In order to purchase beers
  As a customer
  I want to be able to login

  Scenario Outline: Successful login
    Given I am on Login page
    When I enter valid <username> and <password>
    And Click on Sign In button
    Then I should be logged in
    Examples:
      | username | password    |
      | admin1   | parola123A! |
      | admin2   | parola123!A |