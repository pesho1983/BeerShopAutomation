Feature: Basket functionality
  In order to make orders
  As a user
  I want to be able to purchase products from my shopping cart


  Scenario: Empty Basket
    Given The user is logged in:
      | username | pesho       |
      | password | parola123A! |
    When The user navigates to basket page
    Then Informational message "Your cart is empty....." should appear

  Scenario: Add single product
    Given The user is logged in:
      | username | pesho       |
      | password | parola123A! |
    When The user adds product to shopping cart
    Then The user should be redirected to "Basket"
    And The product is present

  Scenario: Add multiple beers
    Given Given The user is logged in:
      | username | pesho       |
      | password | parola123A! |
    When The user adds multiple products to shopping cart
    Then The user should be redirected to "Basket"
    And The products are present

  Scenario: Back to Catalog from Basket Page
    Given Given The user is logged in:
      | username | pesho       |
      | password | parola123A! |
    And On the Basket Page
    When Pressing "Continue Shopping" button is clicked
    Then The user is redirected to "Catalog"

  Scenario: Redirect to "Wallet"
    Given Given The user is logged in:
      | username | pesho       |
      | password | parola123A! |
    And On the Basket Page
    When Pressing the wallet icon
    Then The user is redirected to wallet page

  Scenario: Removing product
    Given The user is logged in:
      | username | pesho       |
      | password | parola123A! |
    And On the Basket Page
    And Product is added to the basket
    When Pressing on the trash button icon
    Then The product is removed from the "Basket"

  Scenario: Redirecting to "Checkout"
    Given The user is logged in:
      | username | pesho       |
      | password | parola123A! |
    And On the Basket Page
    And Product is added to the basket
    When Pressing the "Checkout" button
    Then The user is redirected to "checkout page"

  Scenario: Change positive quantity
    Given The user is logged in:
      | username | pesho       |
      | password | parola123A! |
    And On the Basket Page
    And Product is added to the basket
    When The user increases the quantity
    Then The product quantity should be changed

  Scenario: Change with negative quantity
    Given The user is logged in:
      | username | pesho       |
      | password | parola123A! |
    And On the Basket Page
    And Product is added to the basket
    When The user sets quantity to negative number
    Then An alert message appears
    And Product quantity remains unchanged

  Scenario: Change quantity to zero
    Given The user is logged in:
      | username | pesho       |
      | password | parola123A! |
    And On the Basket Page
    And Product is added to the basket
    When The user sets quantity to zero
    Then The product is removed from cart

  Scenario: Calculate product subtotal
    Given The user is logged in:
      | username | pesho       |
      | password | parola123A! |
    And On the Basket Page
    And Product is added to the basket
    When The user increases the quantity
    Then The product subtotal should be calculated

  Scenario: Calculate basket total
    Given The user is logged in:
      | username | pesho       |
      | password | parola123A! |
    And On the Basket Page
    When Adding multiple product to the basket
    Then Basket total price is summed

  Scenario: Checkout shipping details
    Given The user is logged in:
      | username | pesho       |
      | password | parola123A! |
    And On the Basket Page
    When Pressing the "Checkout" button
    Then The shipping details are displayed
    And The information corresponds to the logged user

  Scenario: Place order successfully
    Given The user is logged in:
      | username | pesho       |
      | password | parola123A! |
    And On the "Checkout" page
    When Pressing the "Place order" button
    Then The user is redirected to an order success page
    And The success order message appears

  Scenario: Place order with insufficient funds
    Given The user is logged in:
      | username | pesho       |
      | password | parola123A! |
    And On the "Checkout" page
    When Pressing the "Place order" button
    Then An error message about insufficient funds appears

  Scenario: Insufficient amount of beers
    Given The user is logged in:
      | username | pesho       |
      | password | parola123A! |
    And On the "Checkout" page
    When Pressing the "Place order" button
    Then An error message about insufficient amount appears

