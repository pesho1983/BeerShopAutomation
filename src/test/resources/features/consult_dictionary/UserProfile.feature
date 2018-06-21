Feature: User profile functionality
  In order to view my information and change it
  As an end user
  I want to have an individual profile with information about me and my favourite beers

  Background:
    Given a user is on Profile page logged in with:
      | username | password    |
      | pesho    | parola123A! |

  Scenario: Upload a new profile picture
    When a "picture" is chosen and uploaded
    Then user profile should be updated


  Scenario: Try to upload picture without selecting file
    When no picture is chosen and upload button is clicked
    Then user should see message "Please select a picture."


  Scenario: Try to upload picture that is not an image
    When a "file" is chosen and uploaded
    Then user should see message "Submitted file is not an image."


  Scenario Outline: Update info about me
    When user updates info about me field:
      | info   |
      | <info> |
    Then user info about me should be updated
    Examples:
      | info        |
      | adsasdfa    |
      | 21414       |
      | Аз съм Пешо |


  Scenario: Navigate to change info page
    When user clicks the "Change info" button
    Then user should be redirected to "Edit Profile"


  Scenario: Navigate to basket from profile page
    When the user navigates to basket page
    Then user should be redirected to "Basket"


  Scenario: Navigate to wallet from profile page
    Given user is at bottom of profile page
    When user clicks the "Wallet" link
    Then user should be redirected to "Wallet"
