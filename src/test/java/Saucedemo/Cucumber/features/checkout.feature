Feature: Checkout Process on Saucedemo Website

  Scenario: Completing the Checkout Process
    Given User is on the Saucedemo home page
    When User clicks the cart button
    And User clicks the checkout button
    And User inputs the first name in the first name field
    And User inputs the second name in the second name field
    And User inputs the zip code in the zip code field
    And User clicks the continue button
    And User clicks the finish button
    Then User completes the checkout process successfully

  Scenario : User proceeds to checkout without filling in the first name
    Given the User is on the Saucedemo home page
    When the User clicks the cart button
    And the User clicks the checkout button
    And the User inputs data into the second name field
    And the User inputs data into the zip code field
    And the User clicks the continue button
    Then an error message should appear indicating that the first name must be filled
