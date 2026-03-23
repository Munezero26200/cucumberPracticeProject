Feature: Remove product from cart
  As a customer
  I want to remove a product from the cart
  so that I can update my purchases before checkout

@remove
  Scenario Outline: Customer to remove a product from cart
    Given I am on cart page
    And I have one product in cart
    When I Click on cross icon beside the "<product-name>"
    Then Product should be deleted confirmed with confirmation message says '"<product-name>" removed. Undo?'

    Examples:
      | product-name |
      | Blue Shoes   |

