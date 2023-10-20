#  Author: Belesti Yenegeta
#  Date: Sep 18, 2023
#  Project name: eBay Test
#  Module: ebay Login
#  Activity: ebay
#  Project owner: EBAY

@Regression
@EbayLogin
Feature: Ebay Test
  Background: user opened web browser and maximizes it
    When user has entered ebay system URL

  Scenario Outline: create ebay account
    And user clicks on the register link
    Then user would land on create account page
    And user enters "<firstName>" into first name text field
    And user enters "<lastName>" into last name text field
    And user enters "<email>" into the email text field
    And user enters "<password>" into the password text field
    And user clicks on the Create Account button

    Examples:
      | firstName | lastName | email                | password       |
      | Bel       | Yen      | belestibdu@gmail.com | QmVsQGFtYXojNA |

  Scenario Outline: sign in to ebay
    And user clicks on the sign in link
    Then user would land on the sign in page
    And user enters "<email>" into user id text field
    And user clicks on the Sign-in Continue button
    And user enters "<password>" into the pass text field
    And user clicks on the Sign in button
    Then user would get "<profileName>" in the profile menu

    Examples:
      | email                | password       | profileName |
      | belestibdu@gmail.com | QmVsQGFtYXojNA | Bel         |





