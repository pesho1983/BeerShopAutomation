Feature: basket functionality
  In order to make orders
  As a user
  I want to be able to purchase products from my shopping cart

  Background:
    Given a user is logged in:
      | username | password    |
      | pesho    | parola123A! |

  Scenario: Empty basket by default
    When the user navigates to basket page
    Then informational message "Your cart is empty....." should appear


  Scenario Outline: Add single product to basket
    When user adds product <productId> to shopping cart
    Then user should be redirected to "Basket"
    And the product is present
    Examples:
      | productId |
      | 1         |
      | 2         |
      | 3         |
      | 4         |
      | 5         |
      | 6         |
      | 7         |
      | 8         |
      | 9         |
      | 10        |
      | 11        |
      | 12        |

  Scenario Outline: Add multiple beers to basket and calculate total
    When the user adds <multiple> products to shopping cart
    Then the products are present
    And basket total price is summed
    Examples:
    |multiple|
    |2       |
    |4       |
    |6       |
    |8       |
    |11      |

  Scenario: Back to catalog from basket
    Given user had added product in his basket
    When user clicks the "Continue Shopping" button
    Then user should be redirected to "Catalog"

  Scenario: Redirect to "Wallet" from basket
    Given user is on the "Basket" page
    When user clicks the "Wallet" icon
    Then user should be redirected to "Personal wallet"

  Scenario: Removing product from basket
    Given user had added product in his basket
    When user clicks the "Thrash" icon
    Then the product is removed from the "Basket"

  Scenario: Redirect to "Checkout" from basket
    Given user had added product in his basket
    When user clicks the "Checkout" button
    Then user should be redirected to "Checkout"

  Scenario: Change product quantity with positive number
    Given user had added product in his basket
    When the user changes the quantity:
      | quantity | 50 |
    Then the product quantity should be changed

    #When trying to change product quantity to a negative number an alert should pop-up and after accepting the alert, beer quantity should remain unchanged.
  Scenario: Change product quantity with negative number
    Given user had added product in his basket
    When the user changes the quantity:
      | quantity | -500 |
    Then product quantity remains unchanged

  Scenario: Set product quantity to zero
    Given user had added product in his basket
    When the user changes the quantity:
      | quantity | 0 |
    Then the product is removed from cart

  Scenario: Calculate product subtotal
    Given user had added product in his basket
    When the user changes the quantity:
      | quantity | 50 |
    Then the product subtotal should be calculated

  Scenario: Checkout shows correct shipping details
    Given user had added product in his basket
    When user clicks the "Checkout" button
    Then the "Shipping Details" are displayed
    And the information corresponds to the logged user

    #TODO: Add a step for depositing money in wallet to guarantee the user has enough funds
  Scenario: Place order successfully
    Given user had added product in his basket
    And the user is on wallet page with zero funds:
      | deposit | 2500000 |
    And user is on the "Basket" page
    When user clicks the "Checkout" button
    And user clicks the "Place order" button
    Then user should be redirected to "Order Success"
    And the "Your order has submitted successfully." message appears

  Scenario: Place order with insufficient amount of beers in stock
    Given user had added product in his basket
    When the user changes the quantity:
      | quantity | 1000 |
    When user clicks the "Checkout" button
    And user clicks the "Place order" button
    Then an error message containing "We don't have" appears

    #TODO: Add a step to remove all funds from user account when wallet steps are implemented.
  Scenario: Place order with insufficient funds
    Given user had added product in his basket
    When the user changes the quantity:
      | quantity | 10000 |
    And the user is on wallet page with zero funds:
      | deposit | -100000000 |
    And user is on the "Basket" page
    And user clicks the "Checkout" button
    And user clicks the "Place order" button
    Then an error message "You don't have enough funds in your account to make this order!" appears





