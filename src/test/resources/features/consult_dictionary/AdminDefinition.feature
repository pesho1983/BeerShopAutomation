Feature: Admin panel
  As administrator I want to be able to manage the products in the website, to upload new beers,to amend them if any changes appear or to remove them.
  As administrator I want to be able to track all purchases of the users and be able to manage them in easy way.


  Scenario: Log in with valid admin credentials
    Given I am on the log in page
    When Filling the form with admin access credentials:
      | username | admin       |
      | password | parola123A! |
    Then You are logged in as "admin"
    And Redirected to "Admin Panel"

  Scenario: Log in with invalid admin credentials
    Given I am on the log in page
    When Filling the form with admin access credentials:
      | username | admin1      |
      | password | parola123a! |
    Then Error message "Wrong username or password!" appears
    And The user is on the "Login page"

  Scenario: Creating product with all valid fields
    Given You are logged in as administrator:
      | username | admin       |
      | password | parola123A! |
    When You are on the "Add beer" page
    And Filling the beer description:
      | beerName        | TestBeer1912                                   |
      | beerDescription | <----------BEER TEST TEXT GOES HERE----------> |
      | beerPrice       | 1.99                                           |
      | beerQuantity    | 100                                            |
    Then Successful message pops up:"Uploaded successfully."

  Scenario: Creating product without name
    Given You are logged in as administrator:
      | username | admin       |
      | password | parola123A! |
    When You are on the "Add beer" page
    And Filling the beer description:
      | beerName        |                                                |
      | beerDescription | <----------BEER TEST TEXT GOES HERE----------> |
      | beerPrice       | 1.99                                           |
      | beerQuantity    | 100                                            |
    Then process is stopped and user remains on "Create a new beer" page

  Scenario: Creating product without description
    Given You are logged in as administrator:
      | username | admin       |
      | password | parola123A! |
    When You are on the "Add beer" page
    And Filling the beer description:
      | beerName        | TestBeer32 |
      | beerDescription |            |
      | beerPrice       | 1.99       |
      | beerQuantity    | 100        |
    Then process is stopped and user remains on "Create a new beer" page

  Scenario: Creating product without price
    Given You are logged in as administrator:
      | username | admin       |
      | password | parola123A! |
    When You are on the "Add beer" page
    And Filling the beer description:
      | beerName        | TestBeer 33                                    |
      | beerDescription | <----------BEER TEST TEXT GOES HERE----------> |
      | beerPrice       |                                                |
      | beerQuantity    | 100                                            |
    Then process is stopped and user remains on "Create a new beer" page

  Scenario: Creating product without quantity
    Given You are logged in as administrator:
      | username | admin       |
      | password | parola123A! |
    When You are on the "Add beer" page
    And Filling the beer description:
      | beerName        | TestBeer                                       |
      | beerDescription | <----------BEER TEST TEXT GOES HERE----------> |
      | beerPrice       | 2                                              |
      | beerQuantity    |                                                |
    Then process is stopped and user remains on "Create a new beer" page

  Scenario: Creating product without picture
    Given You are logged in as administrator:
      | username | admin       |
      | password | parola123A! |
    When You are on the "Add beer" page
    And Complete the beer description without picture:
      | beerName        | TestBeer11                                     |
      | beerDescription | <----------BEER TEST TEXT GOES HERE----------> |
      | beerPrice       | 2                                              |
      | beerQuantity    | 100                                            |
    Then process is stopped and user remains on "Create a new beer" page

  Scenario: "Back to products" redirect button
    Given You are logged in as administrator:
      | username | admin       |
      | password | parola123A! |
    When You are on the "Add beer" page
    And Pressing the "Back to products" button
    Then You are redirected to "All Beers" page

  Scenario Outline: Edit beer name
    Given You are logged in as administrator:
      | username | admin       |
      | password | parola123A! |
    When Filling the beer name <beerName>
    Then Successful message "Record was updated." pops up
    Examples:
      | beerName |
      | EDIT1912 |

  Scenario Outline: Edit beer description
    Given You are logged in as administrator:
      | username | admin       |
      | password | parola123A! |
    When Filling the beer description <beerDescription>
    Then Successful message "Record was updated." pops up
    Examples:
      | beerDescription  |
      | DESCRIPTION EDIT |

  Scenario Outline: Edit beer price
    Given You are logged in as administrator:
      | username | admin       |
      | password | parola123A! |
    When Filling the beer price <beerPrice>
    Then Successful message "Record was updated." pops up
    Examples:
      | beerPrice |
      | 5.12      |

  Scenario Outline: Edit beer quantity
    Given You are logged in as administrator:
      | username | admin       |
      | password | parola123A! |
    When Filling the beer quantity <beerQuantity>
    Then Successful message "Record was updated." pops up
    Examples:
      | beerQuantity |
      | 55           |


  Scenario: Edit beer picture
    Given You are logged in as administrator:
      | username | admin       |
      | password | parola123A! |
    When You are on the Edit beer page
    And changing the beer picture
    Then Successful message "Record was updated." pops up

  Scenario: Delete beer
    Given You are logged in as administrator:
      | username | admin       |
      | password | parola123A! |
    When You are on the Edit beer page
    And Pressing the delete button for a single beer
    Then Successful message "Record was deleted." on beer deletion pops

