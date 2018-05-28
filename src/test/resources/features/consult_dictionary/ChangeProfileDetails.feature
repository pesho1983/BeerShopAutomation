Feature: Change Profile Details
  In order to purchase beers
  As a customer
  I want to be able to be able to updtae my profile details

  Scenario: Change Profile Details
    Given I am logged in
      | username | ivan05      |
      | password | parola123A! |
    And Profile page is loaded
    And Change your details header should be displayed
    When I change my details
      | email     | pesho@abv.bg    |
      | firstName | Peshko          |
      | lastName  | Ivanov          |
      | address   | Sofia, Bulgaria |
      | phone     | 0123456789      |
      | age       | 30              |
    And Click on Save button
    Then Success message is displayed

  Scenario: Change Info About Me
    Given I am logged in
      | username | ivan05      |
      | password | parola123A! |
    And Username is displayed
    When I change the info about me
      | info | I don't like to drink beer |
    And I click on Save info
    Then Info about me is updated

  Scenario Outline: Change profile details with invalid data
    Given I am logged in
      | username | ivan05      |
      | password | parola123A! |
    And Profile page is loaded
    When I change my <username>, <email>, <firstName>, <lastName>, <address>, <phone> and <age>
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









