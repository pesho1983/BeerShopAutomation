Feature: basket functionality
  In order to make orders
  As a user
  I want to be able to purchase products from my shopping cart


  Scenario: empty Basket
    Given a user is logged in:
      | username | pesho       |
      | password | parola123A! |
    When a user navigates to basket page
    Then Informational message "Your cart is empty....." should appear

  Scenario: add single product
    Given a user is logged in:
      | username | pesho       |
      | password | parola123A! |
    When user adds product to shopping cart
    Then user should be redirected to "Basket"
    And the product is present

  Scenario: add multiple beers
    Given a user is logged in:
      | username | pesho       |
      | password | parola123A! |
    When a user adds multiple products to shopping cart
    Then a user should be redirected to "Basket"
    And the products are present

  Scenario: back to Catalog from Basket Page
    Given a user is logged in:
      | username | pesho       |
      | password | parola123A! |
    And user is on the "Basket" page
    When pressing "Continue Shopping" button is clicked
    Then a user is redirected to "Catalog"

  Scenario: redirect to "Wallet"
    Given a user is logged in:
      | username | pesho       |
      | password | parola123A! |
    And user is on the "Basket" page
    When pressing the wallet icon
    Then a user is redirected to wallet page

  Scenario: removing product
    Given a user is logged in:
      | username | pesho       |
      | password | parola123A! |
    And user is on the "Basket" page
    And product is added to the basket
    When pressing on the trash button icon
    Then the product is removed from the "Basket"

  Scenario: redirecting to "Checkout"
    Given a user is logged in:
      | username | pesho       |
      | password | parola123A! |
    And user is on the "Basket" page
    And product is added to the basket
    When pressing the "Checkout" button
    Then a user is redirected to "checkout page"

  Scenario: change positive quantity
    Given a user is logged in:
      | username | pesho       |
      | password | parola123A! |
    And user is on the "Basket" page
    And product is added to the basket
    When a user increases the quantity
    Then the product quantity should be changed

  Scenario: change with negative quantity
    Given a user is logged in:
      | username | pesho       |
      | password | parola123A! |
    And user is on the "Basket" page
    And product is added to the basket
    When a user sets quantity to negative number
    Then an alert message appears
    And product quantity remains unchanged

  Scenario: change quantity to zero
    Given a user is logged in:
      | username | pesho       |
      | password | parola123A! |
    And user is on the "Basket" page
    And product is added to the basket
    When a user sets quantity to zero
    Then the product is removed from cart

  Scenario: calculate product subtotal
    Given a user is logged in:
      | username | pesho       |
      | password | parola123A! |
    And user is on the "Basket" page
    And product is added to the basket
    When a user increases the quantity
    Then the product subtotal should be calculated

  Scenario: calculate basket total
    Given a user is logged in:
      | username | pesho       |
      | password | parola123A! |
    And user is on the "Basket" page
    When adding multiple product to the basket
    Then basket total price is summed

  Scenario: checkout shipping details
    Given a user is logged in:
      | username | pesho       |
      | password | parola123A! |
    And user is on the "Basket" page
    When pressing the "Checkout" button
    Then the shipping details are displayed
    And the information corresponds to the logged user

  Scenario: place order successfully
    Given a user is logged in:
      | username | pesho       |
      | password | parola123A! |
    And on the "Checkout" page
    When pressing the "Place order" button
    Then a user is redirected to an order success page
    And the success order message appears

  Scenario: place order with insufficient funds
    Given a user is logged in:
      | username | pesho       |
      | password | parola123A! |
    And on the "Checkout" page
    When pressing the "Place order" button
    Then an error message about insufficient funds appears

  Scenario: insufficient amount of beers
    Given a user is logged in:
      | username | pesho       |
      | password | parola123A! |
    And on the "Checkout" page
    When pressing the "Place order" button
    Then an error message about insufficient amount appears

