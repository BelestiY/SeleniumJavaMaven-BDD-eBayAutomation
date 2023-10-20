#  Author: Belesti Yenegeta
#  Date: Sep 19, 2023
#  Project name: eBay Test
#  Module: ebay Login
#  Activity: ebay
#  Project owner: EBAY

@Regression
@EbayElectronics
Feature: Ebay Test
  Background: user opened web browser and maximizes it
    When user has entered ebay system URL
    And user clicks on the sign in link
    Then user would land on the sign in page

  Scenario Outline: searching playstation under video games & consoles category of electronics menu
    And user enters "<email>" into user id text field
    And user clicks on the Sign-in Continue button
    And user enters "<password>" into the pass text field
    And user clicks on the Sign in button
    Then user would get "<profileName>" in the profile menu
    And user clicks on the Electronics menu
    Then user would land on the Electronics page
    And user selects "<category>" of electronics
    Then user would land on the "<category>" page
    And user clicks on the "<index>" gaming station category
    And user clicks on the "<index>" play station category
    And user selects the "<index>" play station
    And user sets "<quantity>" in the quantity label for the play station
    And user clicks on the Add to cart button to add the selected play station
    Then user would get "<quantity>" play station items in the cart

    Examples:
      | email                | password        | profileName |  category               | index | quantity |
      | belestibdu@gmail.com | QmVsQGFtYXojNA  | Bel         |  Video Games & Consoles | 1     | 2        |