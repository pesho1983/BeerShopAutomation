Feature: Login Functionality
  In order to purchase beers
  As an customer
  I want to be able to login

  Scenario: Successful login
    Given I am on Login page
    When I enter valid username and password:
      | username | admin1      |
      | password | parola123A! |
    And Click on Sign In button
    Then I should be logged in
