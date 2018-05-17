Feature: Register Functionality
  In order to login the site
  as an and user
  I would like to be able to register

  Scenario: Register with valid data
    Given user is on the register page
    When user enters valid data
    |username|ivan06|
    |password|parola123A!|
    |firstname|Ivan|
    |lastname|Stoev|
    |email|ivancho.06@abv.bg|
    |phone|0555874196|
    |address|Sofia, j.k.Ivan Vazov, ul.Balsha N1|
    |age|33|
    And user accepts terms and gdpr
    And click on register
    Then user is redirected to login page

  Scenario: Register with invalid data empty fields
    Given user is on the register page
    When user enters invalid data
      |username| |
      |password| |
      |firstname| |
      |lastname| |
      |email| |
      |phone| |
      |address| |
      |age| |
    And user do not accepts terms and gdpr
    And click on register
    Then error message is displayed



