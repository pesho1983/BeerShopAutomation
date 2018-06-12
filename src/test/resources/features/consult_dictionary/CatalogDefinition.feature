Feature: Catalog page functionality
  In order to purchase beers
  As a user
  I want to be able to sort beers by name and price
  I want to be able to see full description of chosen beer
  I want to be able to add beer to cart, to navigate among pages, to have direct link to wallet

  Scenario Outline: Check sorting functionality
    Given a user is on Catalog page
    When select order by <option>
    And press Sort button
    Then beers should be sorted
    Examples:
      | option    |
      | name      |
      | nameDesc  |
      | price     |
      | priceDesc |
