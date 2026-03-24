#@login
#Feature: login functionality
#
#  As a customer,
#  I want to log in to my account
#  so that my billing details can be saved for future purchases
#
#  Scenario Outline: Customer to login with valid credentials
#    Given I am on Account page
#    When I enter my <usernameOrEmail> and <password>
#    And I click on LOG IN button
#    Then I should be on Dashboard
#    And I should see a welcome message says "<expectedMessage>"
#
#    Examples:
#      | usernameOrEmail   | password  | expectedMessage                      |
#      | tester            | tester123 | Hello tester (not tester? Log out)   |
#      | tester1@gmail.com | 123       | Hello tester1 (not tester1? Log out) |
