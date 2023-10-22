Feature: Adding a Product to Cart on Saucedemo

  Scenario: Adding a Product to the Cart
    Given the User is on the Saucedemo home page
    When clicks on the product name
    And clicks on the Add to Cart button
    And clicks on the Cart button
    Then the product should be added to the cart

  Scenario: Change Item Quantity to Zero in the Cart
    Given the User is on the Saucedemo home page
    And already have item in cart
    When the User clicks on the cart button
    And the User changes the quantity of the item to zero
    Then the item quantity in the cart should be updated to zero
