Feature: Password Change Functionality
  In order to ensure my account defence
  As a customer
  I want to be able to change my password

  Scenario: Successful change password
    Given I am on Profile page logged in with:
      | username | admin2      |
      | password | parola123A! |
    And Click on Change Info button
    And Click on Change Password button
    When I enter valid oldPassword, newPassword and confirmPassword:
      | oldPassword     | parola123A! |
      | newPassword     | parola123!A |
      | confirmPassword | parola123!A |
    And Click on Save button
    Then Password should be successfully changed