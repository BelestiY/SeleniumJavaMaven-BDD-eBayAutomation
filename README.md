# SeleniumJavaMaven-BDD-eBayAutomation
eBay Commercial Site Automation using SeleniumJava-BDD-Maven
# Installation
- Use pom.xml to install the required packages and run this project
# About the Project
It is the automation of eBay commercial site using Robot Framework. POM design pattern & BDD-Cucumber style are applied to develop this project
# Page Objects
The pageObj folder holds the locators and the functions that are called in the step definitions (in the stepDef folder)
- pageObj/AbstractPage contains common functionalities used by other page objects

# Step Definitions
The project consists of four step definitions
- Login test (EbayLoginStepDef.java): this is used to sign in to the eBay site using a valid credential
- Search test (EbaySearchStepDef.java): this is used to do a generic search of a smartwatch using the Jewelry & Watches category
- Electronics test (EbayElectronicsStepDef.java): this is used to search a PlayStation under the Video Games & Consoles category of the Electronics menu
- Fashion test (EbayFashionStepDef.java): this is used to search Fine Jewelry under the Jewelry category of the Fashion menu
# Features
The project consists of four features that define the test steps
- ebaylogin.feature: steps for login test
- ebaysearch.feature: steps for testing a generic Search
- ebayelectronics.feature: steps for testing electronics search
- ebayfashion.feature: steps for testing fashion search
# Config
This folder consists configuration for
- browser selection
- extent report generation
# Report
The target/extent folder consists of ExtentReport.html which shows the result of the last test execution
