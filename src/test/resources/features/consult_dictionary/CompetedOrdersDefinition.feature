Feature: Completed orders Feature
  As a Admin user i want to see completed
  orders

  Scenario: The admin user can open orders page
    Given the user should be logged as admin:
    |username| admin|
    |password| parola123A!|
    When click on USER ORDERS link
    Then the user should be redirected to "http://192.168.10.158/BeerShop/orders.php"


  Scenario: The admin user can open completed orders page
    Given the user should be logged as admin:
      |username| admin|
      |password| parola123A!|
    When click on USER ORDERS link
    And click on completed orders button
    Then the user should be redirected to completed orders page - "http://192.168.10.158/BeerShop/oldOrders.php"


  Scenario: The admin user should see completed order of beer
    Given the user should be logged as admin:
      |username| admin|
      |password| parola123A!|
    When the adminUser should navigate to completed orders page
    Then the adminUser should see order number "175" in the list of completed orders
