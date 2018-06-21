Feature: Add new beer


  Background:
    Given you are logged in as administrator with valid data:
      | username | admin       |
      | password | parola123A! |

  Scenario: Log in admin panel
    When admin clicks on add beers
    When beer all beer credentials are filled:
      | name        | [8a]        |
      | description | Немска бира |
      | price       | 3.50        |
      | quantity    | 1000        |
    Then successful "Uploaded successfully." message appears.


  Scenario Outline: Add Beer /image exist/
    When admin clicks on add beers
    When user add data:
      | name   | description   | price   | quantity   |
      | <name> | <description> | <price> | <quantity> |
    Then <message> appears:
    Examples:
      | name | description                 | price | quantity | message                                        |
      | [8a] | Мон де Ка е трапистка бира. | 8     | 26       | Image already exists. Try to change file name. |


  Scenario Outline: Add Beer /same name/
    When admin clicks on add beers
    When user add credentials but existing name:
      | name   | description   | price   | quantity   |
      | <name> | <description> | <price> | <quantity> |
    Then <message> about the same name is displayed:
    Examples:
      | name | description                                      | price | quantity | message                                                              |
      | ACDC | Тъмно-рубинена на цвят бира, съдържаща 2,5% мед. | 2.5     | 600      | There is a beer with that name in the database. Name must be unique. |


    Scenario: If button "Back to read products" works
      When admin clicks on add beers
      When user click button Back to read products
      Then page with title "All Beers" is loaded