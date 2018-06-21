Feature: Index page functionality
  In order to have an opportunity to shop
  As a user
  I would like to have access to a beer catalog, to have access to my basket and my personal account

  Scenario Outline: Confirm that last three sold beers are shown on Index page
    Given user is on Catalog page logged in with
      | username | password    |
      | TestUser | parola123A! |
    And the user adds <number> products in the basket
    And user is on wallet page and add funds:
      | deposit | 100 |
    And user is on the "Basket" page
    When user clicks the "Checkout" button
    And user clicks the "Place order" button
    Then go back to Index page current bought beer have to be shown
    Examples:
      | number |
      | 1      |
      | 2      |
      | 3      |
