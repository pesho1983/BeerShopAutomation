Feature: Wallet functionality
  User could add money in the wallet
  in order to buy beers when substract money from wallet amount


  Scenario: Add funds to wallet
    Given a user is logged in with valid credentials:
      | username | BatAndro |
      | password | Asdf123! |
    And the user is on wallet page with zero funds:
      | deposit | -100000000 |
    When add additional funds to the personal account:
      | deposit | 100 |
    Then the funds are added to users personal account:
      | funds | Current balance: BGN 100.00 |


  Scenario Outline: Check current balance changes
    Given a user is logged in with valid credentials:
      | username | BatAndro |
      | password | Asdf123! |
    And the user is on wallet page with zero funds:
      | deposit  | -100000000 |
      | deposit  | 100        |
    When add additional funds to the personal account and calculate:
      | deposit   |
      | <deposit> |
    Then current balance increase or decrease with the additional funds:
    Examples:
      | deposit |
      | 20      |
      | -5      |


  Scenario: Check maximal possible current balance
    Given a user is logged in with valid credentials:
      | username | BatAndro |
      | password | Asdf123! |
    And the user is on wallet page
    When add additional funds to the personal account:
      | deposit | 100000000.00 |
    Then current balance is:
      | funds   | Current balance: BGN 99999999.99 |


  Scenario Outline: Check minimal possible current balance
    Given a user is logged in with valid credentials:
      | username | BatAndro |
      | password | Asdf123! |
    And the user is on wallet page with zero funds:
      | deposit  | -100000000 |
    When add additional funds to the personal account and calculate:
      | deposit   |
      | <deposit> |
    Then current balance is:
      | funds     |  Current balance: BGN 0.01  |
    Examples:
      | deposit |
      | 0.01    |
      | 0.011   |
      | 0.0111  |


  Scenario Outline: Check adding special characters
    Given a user is logged in with valid credentials:
      | username | BatAndro |
      | password | Asdf123! |
    And the user is on wallet page with zero funds:
      | deposit | -100000000 |
    When add special characters in deposit field:
      | deposit   |
      | <deposit> |
    Then current balance is the same as before:
      | funds | Current balance: BGN 0.00 |
    Examples:
      | deposit     |
      | aBchktq     |
      | @#^&*(_?    |
      | !~%:;"'-+   |
      | <>/.,\{}[]= |



#  Scenario: Checking to withdraw money from the wallet when buying beer
#    Given the user is logged in with valid credentials:
#      | username | BatAndro |
#      | password | Asdf123! |
#    And the user has enough money in wallet
#    And the user is on order prevew page
#    When click on button place order:
#    Then order has been placed
#    And current amount in wallet is less with total order price
#
#
#  Scenario: Buying beer whith not enough funds in wallet
#    Given the user is logged in with valid credentials:
#      | username | BatAndro |
#      | password | Asdf123! |
#    And there is not enough money in wallet
#    And the user is on order prevew page
#    When click on button place order:
#    Then order hasn't been placed
#    And there is warning message
#



