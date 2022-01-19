Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly



  Scenario Outline: Check product search url is correct
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User clicks search button
    Then User checks that current url contains 'scarf'
    Examples:
      | homePage                            | keyword |
      | https://www.asos.com/            | scarf   |


  Scenario Outline: Check bag page url is correct
    Given User opens '<homePage>' page
    And User clicks myBag button
    Then User checks that current url contains 'bag'
    Examples:
      | homePage                         |
      | https://www.asos.com/            |



  Scenario Outline: Check amount of filters on search page
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User clicks search button
    Then User checks that amount of filters on search page are '<amountOfProducts>'
    Examples:
      | homePage                            | keyword |amountOfProducts |
      | https://www.asos.com/               | scarf     |11               |

  Scenario Outline: Check SignIn form on visibility of elements
    Given User opens '<homePage>' page
    And User clicks myBag button
    And User clicks SignIn form
    And User checks that Join button visible
    And User checks that SignIn button visible
    And User checks Email Address input visibility
    And User checks Password input visibility
    And User checks Forgot Password button visibility

    Examples:
      | homePage                           |
      | https://www.asos.com/              |


  Scenario Outline: Check SignIn Form for warning to fill in email field without password
    Given User opens '<homePage>' page
    And User clicks myBag button
    And User clicks SignIn form
    When User enters email '<keyword>'
    And User clicks SignIn button
    Then User checks that warning is '<warning>'
    Examples:
      | homePage                            | keyword               | warning                     |
      | https://www.asos.com/               |  naniiani33@gmail.com    |Hey, we need a password here|


  Scenario Outline: Check SignIn Form for an error when entering the account incorrectly
    Given User opens '<homePage>' page
    And User clicks myBag button
    And User clicks SignIn form
    When User enters email '<keyword>'
    And User enters password '<password>'
    And User clicks SignIn button
    Then User checks that error about  account is '<error>'
    Examples:
      | homePage                            | keyword               | password    |error|
      | https://www.asos.com/               |  ariasdi56@gmail.com    |arina11      |Looks like either your email address or password were incorrect. Wanna try again?|



  Scenario Outline: Check SignIn Form for an warning when entering the email incorrectly
    Given User opens '<homePage>' page
    And User clicks myBag button
    And User clicks SignIn form
    When User enters email '<keyword>'
    And User enters password '<password>'
    Then User checks that warning about  email is '<warning>'
    Examples:
      | homePage                            | keyword               | password    |warning|
      | https://www.asos.com/               |  xcvbhn   |arina11      |Email fail! Please type in your correct email address|



  Scenario Outline: Check add product to wishlist
    Given User opens '<homePage>' page
    When User makes search by keyword '<searchWord>'
    And User clicks search button
    And User clicks wish list on first product
    And User clicks wish list button
    Then User checks that amount of products in wish list are '<amountOfProducts>'

    Examples:
      | homePage              | searchWord | amountOfProducts |
      | https://www.asos.com/ |             dress     |       1                |

  Scenario Outline: Check the impossibility of adding to the cart without selecting a size
    Given User opens '<homePage>' page
    When User makes search by keyword '<searchWord>'
    And User clicks search button
    And User clicks on first product
    And User clicks Add to Bag button on product
    Then User checks the '<message>'

    Examples:
      | homePage              | searchWord | message                                                  |
      | https://www.asos.com/ | top      | Please select from the available colour and size options |




  Scenario Outline: Check item missing on search page
    Given User opens '<homePage>' page
    When User makes search by keyword '<keywordOfLack>'
    And User clicks search button
    Then User checks lack of products with '<searchHeader>'

    Examples:
      | homePage              | keywordOfLack | searchHeader                |
      | https://www.asos.com/ | idfjgg     | NOTHING MATCHES YOUR SEARCH |



















































