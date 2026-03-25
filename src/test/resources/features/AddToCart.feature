@add
Feature: Add to cart

  As a customer,
  I want to add product to cart
  so that, I can purchase smoothly

  Background:
    Given I am on store page


  Scenario Outline: Customer can add one product to cart from a product detail page
    When I click on the <product-name>
    And I click on ADD TO CART button on the product page
    And I click on VIEW CART link
    Then I should see the cart's page title
    And I should see 1 <product-name> in the cart

    Examples:
      | product-name    |
      | Anchor Bracelet |
      | Blue Shoes      |



  Scenario: Customer can add multiple products to cart
    When I click on ADD TO CART button of the following products
      | Anchor Bracelet   |
      | Blue Denim Shorts |
      | Blue Shoes        |
    And I click on Cart icon
    Then I should be redirected to cart page
    And I should see all the added products
      | Anchor Bracelet   |
      | Blue Denim Shorts |
      | Blue Shoes        |
