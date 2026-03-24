@register
Feature: Registration functionality

  As a new customer,
  I want to register on the Askomdch website
  So that my billing details can be stored and I can complete checkout smoothly.

  Scenario Outline: Customer register with valid credentials
    Given I am on Account page
    When I register with credentials set <credentialSet>
    And I click on Register Button
    Then I should be on Dashboard
    And  I should see a welcome message says "<expectedMessage>"

    Examples:
      | credentialSet | expectedMessage                |
      | 1             | Hello Jp5 (not Jp5? Log out)   |
      | 2             | Hello Coc3 (not Coc3? Log out) |