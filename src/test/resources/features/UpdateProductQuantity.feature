Feature: Update quantity of product in cart

  As a customer,
  I want to update quantity of product I have in cart
  so that, I can adjust my purchase quantity before checkout

  Background:
    Given I am on cart page
    And I have one product in cart
@updateQty
  Scenario: Customer updates product quantity by manually typing the quantity
    When I change the quantity product to 2
    And I click on UPDATE CART button
    Then product should be updated which confirmed by updated subtotal and total

  Scenario: Customer increases product quantity by clicking on increment button
    When I click on increment button
    And  I click on UPDATE CART button
    Then product quantity updated
    And subtotal and total updated accordingly






