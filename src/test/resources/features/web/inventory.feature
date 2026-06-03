@web @inventory
Feature: Inventory Page Functionality
  As a logged in user
  I want to browse and interact with products
  So that I can add items to my cart

  Background:
    Given I am on the SauceDemo login page
    When I enter username "standard_user" and password "secret_sauce"
    And I click the login button

  @smoke
  Scenario: Inventory page displays all products
    Then I should see 6 products on the inventory page

  @cart
  Scenario: Add a single item to the cart
    When I add the "Sauce Labs Backpack" to the cart
    Then the cart badge should show "1"

  @cart
  Scenario: Add multiple items to the cart
    When I add the "Sauce Labs Backpack" to the cart
    And I add the "Sauce Labs Bike Light" to the cart
    Then the cart badge should show "2"

  @cart
  Scenario: Remove an item from the cart
    When I add the "Sauce Labs Backpack" to the cart
    And I remove the "Sauce Labs Backpack" from the cart
    Then the cart badge should not be visible
