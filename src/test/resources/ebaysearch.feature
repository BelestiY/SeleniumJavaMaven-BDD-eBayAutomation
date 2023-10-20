#  Author: Belesti Yenegeta
#  Date: Sep 19, 2023
#  Project name: eBay Test
#  Module: ebay Login
#  Activity: ebay
#  Project owner: EBAY

@Regression
@EbaySearch
Feature: Ebay Test
  Background: user opened web browser and maximizes it
    When user has entered ebay system URL
    And user clicks on the sign in link
    Then user would land on the sign in page

  Scenario Outline: Searching smartwatch using Jewelry & Watches category
    And user enters "<email>" into user id text field
    And user clicks on the Sign-in Continue button
    And user enters "<password>" into the pass text field
    And user clicks on the Sign in button
    Then user would get "<profileName>" in the profile menu
    And user enters "<searchKey>" into Search for anything label
    And user selects "<category>" in the category dropdown
    And user clicks on the Search button
    And user selects the "<index>" search result
    And user selects the "<index>" color
    And user sets "<quantity>" in the quantity label
    And user clicks on the Add to cart button
    Then user would get "<quantity>" items in the cart

    Examples:
      | email                | password        | profileName | searchKey  | category          | index | quantity |
      | belestibdu@gmail.com | QmVsQGFtYXojNA  | Bel         | Smartwatch | Jewelry & Watches | 3     | 1        |