@web @login
Feature: Web Login Functionality
  As a user of SauceDemo
  I want to be able to login with my credentials
  So that I can access the inventory page

  Background:
    Given I am on the SauceDemo login page

  @smoke @positive
  Scenario: Successful login with valid credentials
    When I enter username "standard_user" and password "secret_sauce"
    And I click the login button
    Then I should be redirected to the inventory page
    And the page title should be "Products"

  @negative
  Scenario: Login fails with locked out user
    When I enter username "locked_out_user" and password "secret_sauce"
    And I click the login button
    Then I should see an error message containing "Sorry, this user has been locked out"

  @negative
  Scenario: Login fails with invalid credentials
    When I enter username "invalid_user" and password "wrong_password"
    And I click the login button
    Then I should see an error message containing "Username and password do not match"

  @negative
  Scenario: Login fails when username is empty
    When I enter username "" and password "secret_sauce"
    And I click the login button
    Then I should see an error message containing "Username is required"

  @negative
  Scenario: Login fails when password is empty
    When I enter username "standard_user" and password ""
    And I click the login button
    Then I should see an error message containing "Password is required"

  @smoke @positive
  Scenario Outline: Login with multiple valid users
    When I enter username "<username>" and password "secret_sauce"
    And I click the login button
    Then I should be redirected to the inventory page

    Examples:
      | username                |
      | standard_user           |
      | problem_user            |
      | performance_glitch_user |
