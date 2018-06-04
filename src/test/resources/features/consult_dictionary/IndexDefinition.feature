Feature: Index page functionality
  In order to have an opportunity to shop
  As a user
  I would like to have access to a beer catalog, to have access to my basket and my personal account

  Scenario: Confirm that last sold beer is shown on Index page
    Given user is on Catalog page logged in with
      | username | TestUser    |
      | password | parola123A! |
    And user had added random product in his basket
    And user is on wallet page and add funds:
      | deposit | 100 |
    And user is on the "Basket" page
    When user clicks the "Checkout" button
    And user clicks the "Place order" button
    Then go back to Index page current bought beer have to be shown


  Scenario: Confirm that last three sold beers are shown on Index page
    Given user is on Catalog page logged in with
      | username | TestUser    |
      | password | parola123A! |
    And user had added three random products in his basket
    And user is on wallet page and add funds:
      | deposit | 100 |
    And user is on the "Basket" page
    When user clicks the "Checkout" button
    And user clicks the "Place order" button
    Then go back to Index page current bought beers have to be shown
