Feature: Add new beer

  Scenario: Log in admin panel
    Given you are logged in as administrator with valid data:
      | username | admin       |
      | password | parola123A! |
    When admin clicks on add beers
    And beer all beer credentials are filled:
      | name        | Cocker        |
      | description | hkhkhkhgkgkgkk |
      | price       | 3              |
      | quantity    | 500            |
    Then successful "Uploaded successfully." message appears.


  Scenario Outline: Add Beer /negative/
    Given you are logged in as administrator with valid data:
      | username | admin       |
      | password | parola123A! |
    When admin clicks on add beers
    And user add data:
      | name   | description   | price   | quantity   |
      | <name> | <description> | <price> | <quantity> |
    Then <message> appears:
    Examples:
      | name          | description                                      | price | quantity | message                                                                          |
      | Mont des Cats | Мон де Ка е трапистка бира.                      | 8     | 26       | Image already exists. Try to change file name.Update the record to upload photo. |
      | Koko          | Тъмно-рубинена на цвят бира, съдържаща 2,5% мед. | 4     | 600      | Image already exists. Try to change file name.Update the record to upload photo. |
      | Koko          | Тъмно-рубинена на цвят бира, съдържаща 2,5% мед. | 4     | 600      | There is a beer with that name in the database. Name must be unique.             |


