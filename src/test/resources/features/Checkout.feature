@checkout
Feature:
  As a customer,
  I want to checkout
  so that I can place order


  Scenario: Customer wants to checkout with valid credentials with default payment method
    Given I have one product in cart
    And I am on the checkout page
    When I enter required valid credentials
      | FirstName | LastName | Street address | Town    | State   | Postcode | Email          |
      | yuhi      | five     | sdf234565432   | NewYork | Arizona | 22222    | yuhi@gmail.com |
    And I click on "PLACE ORDER" button
    Then I should see confirmation message says "Thank you. Your order has been received."
    And I should  get the "ORDER NUMBER"
