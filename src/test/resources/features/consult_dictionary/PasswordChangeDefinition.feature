Feature: Password Change Functionality
  In order to ensure my account defence
  As a customer
  I want to be able to change my password

  Scenario Outline: Successful change password
    Given I am on Profile page logged in with:
      | username | admin2      |
      | password | parola123!A |
    And click on change Info button
    And click on change Password button
    When I enter:
      | oldPassword   | newPassword   | confirmPassword   |
      | <oldPassword> | <newPassword> | <confirmPassword> |
    And click on Save button
    Then I should see <validation> <message> on PaswordChange page
    Examples:
      | oldPassword | newPassword | confirmPassword | validation            | message                        |
      | parola123!A | parola123A! | parola123A!     | successPasswordChange | Your profile has been updated. |

  Scenario Outline: Change password with invalid data
    Given I am on Profile page logged in with:
      | username | admin2      |
      | password | parola123A! |
    And click on change Info button
    And click on change Password button
    When I enter:
      | oldPassword   | newPassword   | confirmPassword   |
      | <oldPassword> | <newPassword> | <confirmPassword> |
    And click on Save button
    Then I should see <validation> <message> on PaswordChange page
    Examples:
      | oldPassword | newPassword | confirmPassword | validation              | message                                                                                        |
      | wrongPass   | parola123A! | parola123A!     | errorPasswordChange     | Wrong password!                                                                                |
      | parola123A! | g43qgarg4   | parola123A!     | requiredPasswordSymbols | Password must contains at least 1 special symbol, 1 uppercase letter, 2 numbers and 3 letters. |
      | wrongPass   | parola123A! | gew             | matchPasswordError      | Passwords do not match.                                                                        |
      | gwe         | parola123A! | parola1w23A!    | errorPasswordChange     | Wrong password!                                                                                |
      | gweg        | 4       5   | 44444444444     | matchPasswordError      | Passwords do not match.                                                                        |

  Scenario Outline: Change password with empty fields
    Given I am on Profile page logged in with:
      | username | admin2      |
      | password | parola123A! |
    And click on change Info button
    And click on change Password button
    When I enter:
      | oldPassword   | newPassword   | confirmPassword   |
      | <oldPassword> | <newPassword> | <confirmPassword> |
    And click on Save button
    Then I should see <validation> <message> on PaswordChange page
    Examples:
      | oldPassword | newPassword | confirmPassword | validation                | message                 |
      |             | parola123A! | parola123A!     | oldPasswordValidation     | This field is required. |
      | parola123A! |             | parola123A!     | newPasswordValidation     | This field is required. |
      | wrongPass   | parola123A! |                 | confirmPasswordValidation | This field is required. |
      |             |             |                 | allPasswordValidations    | This field is required. |

  Scenario: Redirect to profilePage
    Given I am on Profile page logged in with:
      | username | admin2      |
      | password | parola123A! |
    And click on change Info button
    And click on change Password button
    When I press Back to your profile button
    Then I should be redirected to "http://192.168.10.158/BeerShop/profile.php"