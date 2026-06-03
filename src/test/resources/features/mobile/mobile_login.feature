@mobile @login
Feature: Mobile Login Functionality
  As a mobile app user
  I want to be able to login with my credentials
  So that I can access the home screen

  Background:
    Given the mobile app is launched

  @smoke @positive
  Scenario: Successful mobile login with valid credentials
    When I enter mobile username "standard_user" and password "secret_sauce"
    And I tap the login button
    Then I should see the home screen with the cart button

  @negative
  Scenario: Mobile login fails with invalid credentials
    When I enter mobile username "invalid_user" and password "wrong_password"
    And I tap the login button
    Then I should see a mobile error message

  @positive
  Scenario: User can logout from mobile app
    When I enter mobile username "standard_user" and password "secret_sauce"
    And I tap the login button
    And I logout from the mobile app
    Then I should be on the mobile login screen
