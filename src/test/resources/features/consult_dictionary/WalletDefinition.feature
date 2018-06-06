Feature: Wallet functionality

  User could add money in the wallet
  in order to buy beers when substract money from wallet amount

  Background:
    Given a user is logged in with valid credentials:
      | username | BatAndro |
      | password | Asdf123! |

  Scenario Outline: Add funds to wallet
    When the user is on the wallet page and check his current balance
    And the user adds "<value>" funds to the personal account
    Then "<value>" funds are added to the account
    Examples:
      | value |
      | 2     |

  Scenario Outline: Check maximal possible current balance
    And the user is on wallet page
    When the user adds "<value>" funds to the personal account
    Then current balance should be "<funds>":
    Examples:
      | value        | funds                            |
      | 100000000.00 | Current balance: BGN 99999999.99 |

  Scenario Outline: Check minimal possible current balance
    When the user is on the wallet page and check his current balance
    And the user adds "<addCash>" funds to the personal account
    And the user adds "<deposit>" funds to the personal account
    Then current balance should be "<funds>":
    Examples:
      | deposit | addCash    | funds                     |
      | 0.01    | -100000000 | Current balance: BGN 0.01 |
      | 0.011   | -100000000 | Current balance: BGN 0.01 |
      | 0.0111  | -100000000 | Current balance: BGN 0.01 |


  Scenario Outline: Check adding special characters
    When the user is on the wallet page and check his current balance
    When the user adds special characters in deposit field:
      | deposit   |
      | <deposit> |
    Then "<value>" funds are added to the account
    Examples:
      | deposit     | value |
      | aBchktq     | 0     |
      | @#^&*(_?    | 0     |
      | !~%:;"'-+   | 0     |
      | <>/.,\{}[]= | 0     |


  Scenario: Checking to withdraw money from the wallet when buying beer
    When the user has enough money to buy beer
    And the user is on order preview page:
      | product | 5 |
    And user press "Checkout" and "Place order" buttons to confirm order
    Then current amount in wallet is less with total order price


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



