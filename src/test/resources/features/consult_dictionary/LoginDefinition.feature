Feature: Login Functionality
  In order to purchase beers
  As a customer
  I want to be able to login

  Scenario Outline: Login with valid data
    Given I am on Login page
    When I enter username and password
      | username   | password   |
      | <username> | <password> |
    And click on Sign In button
    Then I should be logged in and redirected to "http://192.168.10.158/BeerShop/catalog.php#"
    Examples:
      | username | password    |
      | login1   | parola123A! |
      | login2   | parola123!A |

  Scenario Outline: Login with invalid data
    Given I am on Login page
    When I enter username and password
      | username   | password   |
      | <username> | <password> |
    And click on Sign In button
    Then I should see <validation> <message> on Login page
    Examples:
      | username | password    | validation | message                     |
      | admi     | parola123A! | errorLogin | Wrong username or password! |
      | admin2   | ola123!A    | errorLogin | Wrong username or password! |

  Scenario Outline: Check fields validations with empty data
    Given I am on Login page
    When I enter username and password
      | username   | password   |
      | <username> | <password> |
    And click on Sign In button
    Then I should see <validation> <message> on Login page
    Examples:
      | username | password    | validation             | message                 |
      |          | parola123A! | usernameValidation     | This field is required. |
      | admin2   |             | passwordValidation     | This field is required. |
      |          |             | userAndPassValidations | This field is required. |

  Scenario Outline: Check remember me functionality
    Given I am on Login page
    When I enter username and password
      | username   | password   |
      | <username> | <password> |
    And click on Remember me checkbox an press Sign In button
    And I open new browser session
    Then I should be logged in site with same <username>
    Examples:
      | username | password    |
      | login1   | parola123A! |
      | login2   | parola123!A |