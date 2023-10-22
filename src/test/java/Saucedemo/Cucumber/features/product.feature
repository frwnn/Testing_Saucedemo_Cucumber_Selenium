Feature: Removing Products

  Scenario: User removes a product from the shopping cart
    Given the user is logged in and is on the dashboard
    When the user clicks on the product name
    And the user click Add to Cart
    And the user goes to the shopping cart page
    And the user click Remove
    Then the product should be removed from the cart

  Scenario: User removes a product from the dashboard
    Given the user is logged in and is on the dashboard
    When the user click Add to Cart
    And the user click Remove
    Then the product should be removed