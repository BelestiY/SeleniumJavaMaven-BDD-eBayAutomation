#  Author: Belesti Yenegeta
#  Date: Sep 20, 2023
#  Project name: eBay Test
#  Module: ebay Login
#  Activity: ebay
#  Project owner: EBAY

@Regression
@EbayFashion
Feature: Ebay Test
  Background: user opened web browser and maximizes it
    When user has entered ebay system URL
    And user clicks on the sign in link
    Then user would land on the sign in page

  Scenario Outline: searching Fine Jewelry under Jewelry category of fashion menu
    And user enters "<email>" into user id text field
    And user clicks on the Sign-in Continue button
    And user enters "<password>" into the pass text field
    And user clicks on the Sign in button
    Then user would get "<profileName>" in the profile menu
    And user hover over on the Fashion menu
    And user selects "<category>" category of fashion
    Then user would land on the "<category>" page of fashion menu
    And user selects the "<index>" result of the selected category
    And user selects the "<index>" result of the selected fashion item
#    And user sets "<width>" width for the selected fashion item
#    And user sets "<size>" size in the selected fashion item
    And user sets "<quantity>" for the selected fashion item
    And user clicks on the Add to cart button to add the selected fashion category
    Then user would get "<quantity>" added fashion items in the cart

    Examples:
      | email                | password        | profileName |  category               | index | width | size  | quantity |
      | belestibdu@gmail.com | QmVsQGFtYXojNA  | Bel         |  Jewelry                | 1     | 1.8mm | 16    | 4        |