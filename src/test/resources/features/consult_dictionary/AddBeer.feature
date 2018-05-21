Feature: Add new beer

  Scenario: Log in admin panel
    Given you are logged in as administrator with valid data:
      | username | admin       |
      | password | parola123A! |
    When admin clicks on add beers
    And beer all beer credentials are filled:
      | name        | Gogo            |
      | description | hkhkhkhgkgkgkk |
      | price       | 3            |
      | quantity    | 500           |
    Then successful "Uploaded successfully." message appears.



