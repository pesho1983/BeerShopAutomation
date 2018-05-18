Feature: Password Change Functionality
  In order to ensure my account defence
  As a customer
  I want to be able to change my password

  Scenario: Successful change password
    Given I am on Profile page logged in with:
      | username | admin2      |
      | password | parola123!A |
    And click on change Info button
    And click on change Password button
    When I enter correct oldPassword, newPassword and confirmPassword:
      | oldPassword     | parola123!A |
      | newPassword     | parola123A! |
      | confirmPassword | parola123A! |
    And click on Save button
    Then I should see message "Your profile has been updated."

  Scenario Outline: Change password with invalid data
    Given I am on Profile page logged in with:
      | username | admin2      |
      | password | parola123!A |
    And click on change Info button
    And click on change Password button
    When I enter wrong data:
      | oldPassword   | newPassword   | confirmPassword   |
      | <oldPassword> | <newPassword> | <confirmPassword> |
    And click on Save button
    Then I should see "Wrong password!" message
    Examples:
      | oldPassword | newPassword | confirmPassword |
      | wrongPass   | parola123A! | parola123A!     |
      | parola123A! | g43qgarg4   | parola123A!     |
      | wrongPass   | parola123A! | gew             |
      | gwe         | parola123A! | parola1w23A!    |
      | gweg        | 4       5   | 44444444444     |

  Scenario Outline: Change password with empty fields
    Given I am on Profile page logged in with:
      | username | admin2      |
      | password | parola123!A |
    And click on change Info button
    And click on change Password button
    When I enter wrong data:
      | oldPassword   | newPassword   | confirmPassword   |
      | <oldPassword> | <newPassword> | <confirmPassword> |
    And click on Save button
    Then I should see "This field is required." <validation> message
    Examples:
      | oldPassword | newPassword | confirmPassword | validation |
      |             | parola123A! | parola123A!     | 0          |
      | parola123A! |             | parola123A!     | 1          |
      | wrongPass   | parola123A! |                 | 2          |
      |             |             |                 | 3          |

  Scenario: Redirect to profilePage
    Given I am on Profile page logged in with:
      | username | admin2      |
      | password | parola123A! |
    And click on change Info button
    And click on change Password button
    When I press Back to your profile button
    Then I should be redirected to "http://192.168.10.158/BeerShop/profile.php"