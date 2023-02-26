//@CompleteTest
Feature: TEK Retail Application SignIn feature

  Background: 
    Given User is on retail website
    When User click on Sign in option

	
  Scenario: Verify user can sign in into Retail Application
    And User enter email 'sana.Moh2002@gmail.com' and password '@Sana@123'
    And User click on login button
    Then User should be logged in into Account

 
  Scenario Outline: Verify user can sign in into Retail Application
    And User enter email '<email>' and password '<password>'
    And User click on login button
    Then User should be logged in into Account

    Examples: 
      | email                     | password  |
      | sana.Moh2002@tekschool.us | @Sana@123 |
      | sana.Moh2002@gmail.com    | @Sana@123 |

  Scenario: Verify user can create an acount into Retail Website
    And User click on Create New Account button
    And User fill the signUp information with below data
      | name  | email              | password  | confirmPassword |
      | Sana | sana.Moh2002@tek.com | @Sana@123 | @Sana@123       |
    And User click on SignUp button
    Then User should be logged into account page
