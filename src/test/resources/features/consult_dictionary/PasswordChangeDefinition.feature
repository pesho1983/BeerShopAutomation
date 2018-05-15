Feature: Password Change Functionality
  In order to ensure my account defence
  As a customer
  I want to be able to change my password

  Scenario: Successful change password
    Given I am on Profile page logged in with:
      | username | admin2      |
      | password | parola123A! |
    And click on change Info button
    And click on change Password button
    When I enter valid oldPassword, newPassword and confirmPassword:
      | oldPassword     | parola123A! |
      | newPassword     | parola123!A |
      | confirmPassword | parola123!A |
    And click on Save button
    Then password is successfully changed