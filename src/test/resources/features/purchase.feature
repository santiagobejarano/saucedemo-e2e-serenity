# Created by santiagobejarano at 19/9/2025
Feature: Purchase flow on SauceDemo

  @purchase
  Scenario: Complete purchase with two items
    Given User opens the SauceDemo login page
    When he logs in with user "standard_user" and password "secret_sauce"
    And he adds products from json "data/products.json"
    And he goes to the cart
    And he completes checkout using data from "data/checkout-user.json"
    Then he should see the confirmation message "THANK YOU FOR YOUR ORDER"