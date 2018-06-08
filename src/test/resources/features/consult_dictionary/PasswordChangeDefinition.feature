Feature: Password Change Functionality
  In order to ensure my account defence
  As a user
  I want to be able to change my password

  Scenario Outline: Successful change password
    Given a user is on Profile page logged in with:
      | username   | password   |
      | <username> | <password> |
    And click on "Change info" and "Change password" buttons
    When user enter:
      | password   | newPassword   | confirmPassword   |
      | <password> | <newPassword> | <confirmPassword> |
    And click on Save button
    Then <message> message should be displayed for <fieldName> field
    Examples:
      | fieldName       | username | password    | newPassword | confirmPassword | message                        |
      | Change Password | admin2   | parola123!A | parola123A! | parola123A!     | Your profile has been updated. |
      | Change Password | admin2   | parola123A! | parola123!A | parola123!A     | Your profile has been updated. |

  Scenario Outline: Change password with invalid data to check validation messages
    Given a user is on Profile page logged in with:
      | username | password    |
      | admin2   | parola123!A |
    And click on "Change info" and "Change password" buttons
    When user enter:
      | password   | newPassword   | confirmPassword   |
      | <password> | <newPassword> | <confirmPassword> |
    And click on Save button
    Then <message> message should be displayed for <fieldName> field
    Examples:
      | fieldName            | password    | newPassword | confirmPassword | message                                                                                        |
      | Current Password     | wrongPass   | parola123!A | parola123!A     | Wrong password!                                                                                |
      | New Password         | parola123!A | g43qgarg4   | parola123!A     | Password must contains at least 1 special symbol, 1 uppercase letter, 2 numbers and 3 letters. |
      | Confirm New Password | parola123!A | parola123!A | gew             | Passwords do not match.                                                                        |
      | Current Password     | gwe         | parola123!A | parola1w23!A    | Wrong password!                                                                                |

  Scenario Outline: Change password field is blanked to check field validation
    Given a user is on Profile page logged in with:
      | username | password    |
      | admin2   | parola123!A |
    And click on "Change info" and "Change password" buttons
    When user enter:
      | password   | newPassword   | confirmPassword   |
      | <password> | <newPassword> | <confirmPassword> |
    And click on Save button
    Then <message> message should be displayed for <fieldName> field
    Examples:
      | fieldName              | password    | newPassword | confirmPassword | message                 |
      | Empty Current Password |             | parola123A! | parola123A!     | This field is required. |
      | Empty New Password     | parola123A! |             | parola123A!     | This field is required. |
      | Empty Confirm Password | wrongPass   | parola123A! |                 | This field is required. |
      | All Empty              |             |             |                 | This field is required. |

  Scenario: Redirect to profilePage
    Given a user is on Profile page logged in with:
      | username | password    |
      | admin2   | parola123!A |
    And click on "Change info" and "Change password" buttons
    When a user press Back to your profile button
    Then a user should be redirected to "http://192.168.10.158/BeerShop/profile.php"