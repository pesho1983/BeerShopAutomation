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

  #Negative path
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

  #Negative path without checkboxes
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

  #Negative path frontend validation messages check
  Scenario Outline: Check frontend validation messages on Register with invalid data
    Given user is on the register page
    When user enters invalid data for
      | username   | password   | confirmpass   | firstname   | lastname   | email   | phone   | address   | age   |
      | <username> | <password> | <confirmpass> | <firstname> | <lastname> | <email> | <phone> | <address> | <age> |

    And click on register button
    Then an frontend error message  "<Error messages>" appears

    Examples:
      | username | password    | confirmpass | firstname | lastname | email                | phone      | address                             | age | Error messages                      |
      | ivan0013 | parol       | parola123A! | ivan      | todorov  | ivan.todorov3@abv.bg | 0123456789 | Sofia, j.k.Ivan Vazov, ul.Balsha N1 | 18  | Please enter at least 8 characters. |
      | ivan0013 | parola123A! | parola      | ivan      | todorov  | ivan.todorov3@abv.bg | 0123456789 | Sofia, j.k.Ivan Vazov, ul.Balsha N1 | 18  | Please enter at least 8 characters. |
      | ivan0013 | parola123A! | parola123A! |           | todorov  | ivan.todorov3@abv.bg | 0123456789 | Sofia, j.k.Ivan Vazov, ul.Balsha N1 | 18  | This field is required.             |
      | ivan0013 | parola123A! | parola123A! | ivan      |          | ivan.todorov3@abv.bg | 0123456789 | Sofia, j.k.Ivan Vazov, ul.Balsha N1 | 18  | This field is required.             |
      | ivan0013 | parola123A! | parola123A! | ivan      | todorov  | ivan.todorov3abv.bg  | 0123456789 | Sofia, j.k.Ivan Vazov, ul.Balsha N1 | 18  | Please enter a valid email address. |
      | ivan0013 | parola123A! | parola123A! | ivan      | todorov  |                      | 0123456789 | Sofia, j.k.Ivan Vazov, ul.Balsha N1 | 18  | Please enter an email address       |
      | ivan0013 | parola123A! | parola123A! | ivan      | todorov  | ivan.todorov3@abv.bg | 012        | Sofia, j.k.Ivan Vazov, ul.Balsha N1 | 18  | Your phone number must be 10 digits |
      | ivan0013 | parola123A! | parola123A! | ivan      | todorov  | ivan.todorov3@abv.bg | 0123456789 |                                     | 18  | Please enter your address           |
      | ivan0013 | parola123A! | parola123A! | ivan      | todorov  | ivan.todorov3@abv.bg | 0123456789 | Sofia, j.k.Ivan Vazov, ul.Balsha N1 | 17  | Your age must be 18+                |

  #Negative path backend validation messages check
  Scenario Outline: Check backend validation messages on Register with invalid data
    Given user is on the register page
    When user enters invalid data for
      | username   | password   | confirmpass   | firstname   | lastname   | email   | phone   | address   | age   |
      | <username> | <password> | <confirmpass> | <firstname> | <lastname> | <email> | <phone> | <address> | <age> |

    And click on register button
    Then an backend error message  "<Error messages>" appears

    Examples:
      | username | password    | confirmpass | firstname | lastname | email                | phone      | address                             | age | Error messages                                                                                 |
      | ivan0010 | parola123A! | parola123A! | ivan      | todorov  | ivan.todorov3@abv.bg | 0123456789 | Sofia, j.k.Ivan Vazov, ul.Balsha N1 | 18  | That username already exists!                                                                  |
      | ivan0013 | parola123Aa | parola123Aa | ivan      | todorov  | ivan.todorov3@abv.bg | 0123456789 | Sofia, j.k.Ivan Vazov, ul.Balsha N1 | 18  | Password must contains at least 1 special symbol, 1 uppercase letter, 2 numbers and 3 letters. |
      | ivan0013 | parola123A! | parola123A! | ivan      | todorov  | ivan.todorov@abv.bg  | 0123456789 | Sofia, j.k.Ivan Vazov, ul.Balsha N1 | 18  | That email already exists!                                                                     |



