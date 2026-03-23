Feature: Apply coupon functionality

  As a customer,
  I want to apply a coupon to my cart
  so that I can get a discount on my order total

  Background:
    Given I am on cart page
    And I have atleast one product in the cart


  Scenario: Customer applies a valid coupon to the cart
    When I enter "off25" coupon
    And I click on "APPLY COUPON" button
    Then I should see the confirmation message says "Coupon code applied successfully."
    And cart subtotal and total be updated accordingly


  Scenario Outline: Customer applies invalid coupon to the cart
    When I enter "<invalid-coupon>" coupon
    And I click on "Apply COUPON" button
    Then I should see the error message 'Coupon "<invalid-coupon>" does not exist!'
    Examples:
    |invalid-coupon|
    |112           |


  Scenario: Customer applies the same coupon twice on the same cart
    When I enter "off25" coupon
     * I click on "APPLY COUPON" button
     * I enter "off25" coupon
     * I click on "APPLY COUPON" button
    Then I should see the error message says "Coupon code already applied!"



