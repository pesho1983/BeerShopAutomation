Feature: Change Profile Details
  In order to purchase beers
  As a customer
  I want to be able to be able to updtae my profile details

  Scenario: Change Profile Details
    Given I am logged in
      | username | ivan05      |
      | password | parola123A! |
    And Profile page is loaded
    When I change my details
      | email     | pesho@abv.bg    |
      | firstName | Peshko          |
      | lastName  | Ivanov          |
      | address   | Sofia, Bulgaria |
      | phone     | 0123456789      |
      | age       | 30              |
    And Click on Save button
    Then Success message "Your profile has been updated." is displayed

  Scenario Outline: Change Info About Me
    Given I am logged in with
      | username   | password   |
      | <username> | <password> |
    And My <username> is displayed
    When I change the <info> about me
    And I click on Save info
    Then The <info> about me is updated

    Examples:
      | username | password    | info                 |
      | ivan05   | parola123A! | I like to drink beer |


  Scenario Outline: Change profile details with invalid data
    Given I am logged in
      | username | ivan05      |
      | password | parola123A! |
    And Profile page is loaded
    When I change my details with invalid data
      | username   | email   | firstName   | lastName   | address   | phone   | age   | errorMessage   |
      | <username> | <email> | <firstName> | <lastName> | <address> | <phone> | <age> | <errorMessage> |
    And Click on Save button
    Then Correct <errorMessage> is displayed

    Examples:
      | username | email              | firstName | lastName | address | phone      | age | errorMessage                        |
      |          | ivan@abv.bg        | Ivan      | Ivanov   | Sofia   | 0896512364 | 36  | This field is required.             |
      | ivan05   | ivan@              | Ivan      | Ivanov   | Sofia   | 0896512364 | 36  | Please enter a valid email address  |
      | ivan05   | ivan.ivanov@abv.bg |           | Ivanov   | Sofia   | 0896512364 | 36  | This field is required.             |
      | ivan05   | ivan@abv.bg        | Ivan      |          | Sofia   | 0896512364 | 36  | This field is required.             |
      | ivan05   | ivan@abv.bg        | Ivan      | Ivanov   |         | 0896512364 | 36  | Please enter your address           |
      | ivan05   | ivan@abv.bg        | Ivan      | Ivanov   | Sofia   | 08         | 36  | Your phone number must be 10 digits |
      | ivan05   | ivan@abv.bg        | Ivan      | Ivanov   | Sofia   | 0896512364 | -2  | Your age must be 18+                |


  Scenario Outline: Change my profile picture
    Given I am logged in with
      | username   | password   |
      | <username> | <password> |
    And My <username> is displayed
    When I select a new picture
    Then My profile picture is changed

    Examples:
      | username | password    |
      | ivan05   | parola123A! |

  Scenario Outline: Try to upload image before selecting it
    Given I am logged in with
      | username   | password   |
      | <username> | <password> |
    And My <username> is displayed
    When I click on upload file, without choosing a file
    Then <errorMessage> for missing picture is displayed

    Examples:
      | username | password    | errorMessage             |
      | ivan05   | parola123A! | Please select a picture. |





