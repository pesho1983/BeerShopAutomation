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


#  Scenario: The admin user can see completed order of beer
#    Given the user should be logged as admin:
#      |username| admin|
#      |password| parola123A!|
#    And add one beer
#      |name| testbeer2358|
#      |description| Special beer with sweet and hard taste|
#      |price| 2.50|
#      |quantity| 20|
#      |picture| C:\Users\stzvetkachki\Desktop\testBeerPics\mithos_beer_test.jpg|
#    And logged out
#
#    When click on completed orders button
#    And