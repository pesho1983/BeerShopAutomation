Feature: Admin panel
  As administrator I want to be able to manage the products in the website, to upload new beers,to amend them if any changes appear or to remove them.
  As administrator I want to be able to track all purchases of the users and be able to manage them in easy way.


  Scenario: Log in with valid admin credentials
    Given I am on the log in page
    When Filling the form with admin access credentials:
      | username | admin       |
      | password | parola123A! |
    Then You are logged in as admin
    And Redirected to "Admin panel"

  Scenario: Log in with invalid admin credentials
    Given I am on the log in page
    When Filling the form with admin access credentials:
      | username | admin1      |
      | password | parola123a! |
    Then Error message appears
    And The user is on the "Login page"

  Scenario: Creating product with all valid fields
    Given You are logged in as administrator:
      | username | admin       |
      | password | parola123A! |
    When You are on the "Add beer" page
    And Filling the beer description:
      | beerName        | TestBeer                                       |
      | beerDescription | <----------BEER TEST TEXT GOES HERE----------> |
      | beerPrice       | 1.99                                           |
      | beerQuantity    | 100                                            |
    Then Product is loaded to the catalog

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
    Then Pop up error message appears
    And process is stopped

  Scenario: Creating product without description
    Given You are logged in as administrator:
      | username | admin       |
      | password | parola123A! |
    When You are on the "Add beer" page
    And Filling the beer description:
      | beerName        | TestBeer |
      | beerDescription |          |
      | beerPrice       | 1.99     |
      | beerQuantity    | 100      |
    Then Pop up error message appears
    And process is stopped

  Scenario: Creating product without price
    Given You are logged in as administrator:
      | username | admin       |
      | password | parola123A! |
    When You are on the "Add beer" page
    And Filling the beer description:
      | beerName        | TestBeer                                       |
      | beerDescription | <----------BEER TEST TEXT GOES HERE----------> |
      | beerPrice       |                                                |
      | beerQuantity    | 100                                            |
    Then Pop up error message appears
    And process is stopped

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
    Then Pop up error message appears
    And process is stopped

  Scenario: Creating product without picture
    Given You are logged in as administrator:
      | username | admin       |
      | password | parola123A! |
    When You are on the "Add beer" page
    And Filling the beer description:
      | beerName        | TestBeer                                       |
      | beerDescription | <----------BEER TEST TEXT GOES HERE----------> |
      | beerPrice       | 2                                              |
      | beerQuantity    | 100                                            |
    Then Pop up error message appears
    And process is stopped

  Scenario: "Back to products" redirect button
    Given You are logged in as administrator:
      | username | admin       |
      | password | parola123A! |
    When You are on the "Add beer" page
    And Pressing the "Back to products" button
    Then You are redirected to the beer catalog

  Scenario Outline: Edit beer name
    Given You are logged in as administrator:
      | username | admin       |
      | password | parola123A! |
    And Filling the <beerName>
    Then Successful message pops up
    Examples:
      | beerName |
      | EDIT     |

  Scenario Outline: Edit beer description
    Given You are logged in as administrator:
      | username | admin       |
      | password | parola123A! |
    And Filling the <beerDescription>
    Then Successful message pops up
    Examples:
      | beerDescription  |
      | DESCRIPTION EDIT |

  Scenario Outline: Edit beer price
    Given You are logged in as administrator:
      | username | admin       |
      | password | parola123A! |
    And Filling the <beerPrice>
    Then Successful message pops up
    Examples:
      | beerPrice |
      | 5.12      |

  Scenario Outline: Edit beer quantity
    Given You are logged in as administrator:
      | username | admin       |
      | password | parola123A! |
    And Filling the <beerQuantity>
    Then Successful message pops up
    Examples:
      | beerQuantity |
      | 55           |

  Scenario: Edit beer picture
    Given You are logged in as administrator:
      | username | admin       |
      | password | parola123A! |
    When You are on the "Edit beer" page
    And changing the beer picture
    Then Pop up error message appears

  Scenario: Delete beer
    Given You are logged in as administrator:
      | username | admin       |
      | password | parola123A! |
    When You are on the "Edit beer" page
    And Pressing the delete button for a single beer
    Then Confirmation pop up appears

