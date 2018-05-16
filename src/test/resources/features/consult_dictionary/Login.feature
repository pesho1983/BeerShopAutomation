Feature: Add new beer

  Scenario: Log in admin panel
    Given you are logged in as administrator with valid data:
      | username | admin       |
      | password | parola123A! |
    When admin  clicks on add beers
    And beer all beer credentials are filled:
      | name        | FF             |
      | description | hkhkhkhgkgkgkk |
      | price       | 20             |
      | quantity    | 800            |
    Then beer is successfully added to the  list



