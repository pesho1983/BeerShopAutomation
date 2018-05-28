Feature: Register Functionality
  In order to login the site
  as an user
  I would like to be able to register

  #Positive path
  Scenario Outline: Register with valid data
    Given user is on the register page
    When user enters valid data
      | username   | password   | firstname   | lastname   | email   | phone   | address   | age   |
      | <username> | <password> | <firstname> | <lastname> | <email> | <phone> | <address> | <age> |


    And click on register button
    Then user is redirected to login "http://192.168.10.158/BeerShop/login.php#" url

    Examples:
      | username | password        | firstname | lastname | email | phone | address                             | age |
      | [8a]     | ola123A!        | Ivan      | Stoev    | [9a]  | [10]  | Sofia, j.k.Ivan Vazov, ul.Balsha N6 | 18  |
      | [8a]     | parola123A!     | Ivan      | Stoev    | [9a]  | [10]  | Sofia, j.k.Ivan Vazov, ul.Balsha N1 | 18  |
      | [4a]     | parola123A!     | Ivan      | Stoev    | [9a]  | [10]  | Sofia, j.k.Ivan Vazov, ul.Balsha N3 | 99  |
      | [8a]     | parola123A!paro | Ivan      | Stoev    | [9a]  | [10]  | Sofia, j.k.Ivan Vazov, ul.Balsha N6 | 18  |

  #Negative path frontend validation
  Scenario Outline: Register with invalid data with checked checkboxes
    Given user is on the register page
    When user enters invalid data for
      | username   | password   | confirmpass   | firstname   | lastname   | email   | phone   | address   | age   |
      | <username> | <password> | <confirmpass> | <firstname> | <lastname> | <email> | <phone> | <address> | <age> |

    And click on register button
    Then user is redirected to register "http://192.168.10.158/BeerShop/register.php" url

    Examples:
      | username | password    | confirmpass | firstname | lastname | email                | phone      | address                             | age |
      | ivan0012 | parol       | parola123A! | ivan      | todorov  | ivan.todorov2@abv.bg | 0123456789 | Sofia, j.k.Ivan Vazov, ul.Balsha N1 | 18  |
      | ivan0012 | parola123A! | parola      | ivan      | todorov  | ivan.todorov2@abv.bg | 0123456789 | Sofia, j.k.Ivan Vazov, ul.Balsha N1 | 18  |
      | ivan0012 | parola123A! | parola123A! |           | todorov  | ivan.todorov2@abv.bg | 0123456789 | Sofia, j.k.Ivan Vazov, ul.Balsha N1 | 18  |
      | ivan0012 | parola123A! | parola123A! | ivan      |          | ivan.todorov2@abv.bg | 0123456789 | Sofia, j.k.Ivan Vazov, ul.Balsha N1 | 18  |
      | ivan0012 | parola123A! | parola123A! | ivan      | todorov  | ivan.todorov2abv.bg  | 0123456789 | Sofia, j.k.Ivan Vazov, ul.Balsha N1 | 18  |
      | ivan0012 | parola123A! | parola123A! | ivan      | todorov  | ivan.todorov2@abv.bg | 012        | Sofia, j.k.Ivan Vazov, ul.Balsha N1 | 18  |
      | ivan0012 | parola123A! | parola123A! | ivan      | todorov  | ivan.todorov2@abv.bg | 0123456789 |                                     | 18  |
      | ivan0012 | parola123A! | parola123A! | ivan      | todorov  | ivan.todorov2@abv.bg | 0123456789 | Sofia, j.k.Ivan Vazov, ul.Balsha N1 | 17  |

  #Negative path backend validation
  Scenario Outline: Register with invalid data with checked checkboxes
    Given user is on the register page
    When user enters invalid data for
      | username   | password   | confirmpass   | firstname   | lastname   | email   | phone   | address   | age   |
      | <username> | <password> | <confirmpass> | <firstname> | <lastname> | <email> | <phone> | <address> | <age> |

    And click on register button
    Then user is redirected to register # "http://192.168.10.158/BeerShop/register.php#" url

    Examples:
      | username | password    | confirmpass | firstname | lastname | email                | phone      | address                             | age |
      | ivan0010 | parola123A! | parola123A! | ivan      | todorov  | ivan.todorov2@abv.bg | 0123456789 | Sofia, j.k.Ivan Vazov, ul.Balsha N1 | 18  |
      | ivan0012 | parola123Aa | parola123Aa | ivan      | todorov  | ivan.todorov2@abv.bg | 0123456789 | Sofia, j.k.Ivan Vazov, ul.Balsha N1 | 18  |
      | ivan0012 | parola123A! | parola123A! | ivan      | todorov  | ivan.todorov@abv.bg  | 0123456789 | Sofia, j.k.Ivan Vazov, ul.Balsha N1 | 18  |

  #Negative path
  Scenario Outline: Register with invalid data with unchecked checkboxes
    Given user is on the register page
    When user enters invalid data with unchecked checkboxes for
      | username   | password   | confirmpass   | firstname   | lastname   | email   | phone   | address   | age   |
      | <username> | <password> | <confirmpass> | <firstname> | <lastname> | <email> | <phone> | <address> | <age> |

    And click on register button
    Then user is redirected to register "http://192.168.10.158/BeerShop/register.php" url

    Examples:
      | username | password    | confirmpass | firstname | lastname | email                | phone      | address                             | age |
      | ivan0010 | parola123A! | parola123A! | ivan      | todorov  | ivan.todorov2@abv.bg | 0123456789 | Sofia, j.k.Ivan Vazov, ul.Balsha N1 | 18  |
      | ivan0012 | parola123Aa | parola123Aa | ivan      | todorov  | ivan.todorov2@abv.bg | 0123456789 | Sofia, j.k.Ivan Vazov, ul.Balsha N1 | 18  |
      | ivan0012 | parola123A! | parola123A! | ivan      | todorov  | ivan.todorov@abv.bg  | 0123456789 | Sofia, j.k.Ivan Vazov, ul.Balsha N1 | 18  |
      | ivan0012 | parol       | parola123A! | ivan      | todorov  | ivan.todorov2@abv.bg | 0123456789 | Sofia, j.k.Ivan Vazov, ul.Balsha N1 | 18  |
      | ivan0012 | parola123A! | parola      | ivan      | todorov  | ivan.todorov2@abv.bg | 0123456789 | Sofia, j.k.Ivan Vazov, ul.Balsha N1 | 18  |
      | ivan0012 | parola123A! | parola123A! |           | todorov  | ivan.todorov2@abv.bg | 0123456789 | Sofia, j.k.Ivan Vazov, ul.Balsha N1 | 18  |
      | ivan0012 | parola123A! | parola123A! | ivan      |          | ivan.todorov2@abv.bg | 0123456789 | Sofia, j.k.Ivan Vazov, ul.Balsha N1 | 18  |
      | ivan0012 | parola123A! | parola123A! | ivan      | todorov  | ivan.todorov2abv.bg  | 0123456789 | Sofia, j.k.Ivan Vazov, ul.Balsha N1 | 18  |
      | ivan0012 | parola123A! | parola123A! | ivan      | todorov  | ivan.todorov2@abv.bg | 012        | Sofia, j.k.Ivan Vazov, ul.Balsha N1 | 18  |
      | ivan0012 | parola123A! | parola123A! | ivan      | todorov  | ivan.todorov2@abv.bg | 0123456789 |                                     | 18  |
      | ivan0012 | parola123A! | parola123A! | ivan      | todorov  | ivan.todorov2@abv.bg | 0123456789 | Sofia, j.k.Ivan Vazov, ul.Balsha N1 | 17  |
