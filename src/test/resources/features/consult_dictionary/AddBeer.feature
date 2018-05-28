Feature: Add new beer

  Scenario: Log in admin panel
    Given you are logged in as administrator with valid data:
      | username | admin       |
      | password | parola123A! |
    When admin clicks on add beers
    When beer all beer credentials are filled:
      | name        | Temp           |
      | description | hkhkhkhgkgkgkk |
      | price       | 8              |
      | quantity    | 1000           |
    Then successful "Uploaded successfully." message appears.


  Scenario Outline: Add Beer /negative/
    Given you are logged in as administrator with valid data:
      | username | admin       |
      | password | parola123A! |
    When admin clicks on add beers
    When user add data:
      | name   | description   | price   | quantity   |
      | <name> | <description> | <price> | <quantity> |
    Then <message> appears:
    Examples:
      | name          | description                                      | price | quantity | message                                        |
      | Mont des Cats | Мон де Ка е трапистка бира.                      | 8     | 26       | Image already exists. Try to change file name. |
      | Koko          | Тъмно-рубинена на цвят бира, съдържаща 2,5% мед. | 4     | 600      | Image already exists. Try to change file name. |


  Scenario Outline: Add Beer /same name/
    Given you are logged in as administrator with valid data:
      | username | admin       |
      | password | parola123A! |
    When admin clicks on add beers
    When user add data:
      | name   | description   | price   | quantity   |
      | <name> | <description> | <price> | <quantity> |
    Then <message> about the same name is displayed:
    Examples:
      | name | description                                      | price | quantity | message                                                              |
      | Koko | Тъмно-рубинена на цвят бира, съдържаща 2,5% мед. | 4     | 600      | There is a beer with that name in the database. Name must be unique. |
