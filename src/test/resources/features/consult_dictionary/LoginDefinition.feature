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
    Then message <message> should be displayed for <fieldName> field
    Examples:
      | fieldName     | username | password    | message                     |
      | wrong data in | admi     | parola123A! | Wrong username or password! |
      | wrong data in | admin2   | ola123!A    | Wrong username or password! |

  Scenario Outline: Check fields validations with empty data
    Given I am on Login page
    When I enter username and password
      | username   | password   |
      | <username> | <password> |
    And click on Sign In button
    Then message <message> should be displayed for <fieldName> field
    Examples:
      | fieldName      | username | password    | message                 |
      | empty username |          | parola123A! | This field is required. |
      | empty password | admin2   |             | This field is required. |
      | all empty      |          |             | This field is required. |

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