Feature: Wallet functionality
  User could add money in the wallet
  in order to buy beers when substract money from wallet amount


  Scenario: Add funds to wallet
    Given the user is logged in with valid credentials:
      | username | BatAndro |
      | password | Asdf123! |
    And the user is on wallet page with zero funds:
      | deposit | -100000000 |
    When adding additional funds to the personal account:
      | deposit | 100 |
    Then the funds are added to users personal account


#  Scenario: Check  current balance
#    Given the user is logged in with valid credentials:
#      | username | BatAndro |
#      | password | Asdf123! |
#    And the user is on wallet page
#    When adding additional funds to the personal account:
#      | deposit | 10 |
#    Then current balance will increased with additional funds
#
#
#  Scenario: Check maximal possible current balance
#    Given the user is logged in with valid credentials:
#      | username | BatAndro |
#      | password | Asdf123! |
#    And the user is on wallet page
#    When adding additional funds to the personal account:
#      | deposit | 100000000.00 |
#    Then current balance will be 99999999.99
#
#
#  Scenario: Check minimal possible current balance
#    Given the user is logged in with valid credentials:
#      | username | BatAndro |
#      | password | Asdf123! |
#    And the user is on wallet page
#    When adding additional funds to the personal account:
#      | deposit | 0.01  |
#      | deposit | 0.001 |
#    Then current balance will be 0.01
#
#
#  Scenario: Check adding special characters
#    Given the user is logged in with valid credentials:
#      | username | BatAndro |
#      | password | Asdf123! |
#    And the user is on wallet page
#    When adding special characters in deposit field:
#      | deposit | @#^&*(_? |
#    Then current balance will be the same as before
#
#
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


