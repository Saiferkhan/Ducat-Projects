Feature: Login Functionality

  Scenario: Successful login with valid credentials
    Given User is on the login page
    When Enter the username and password
    And User click on the login button
    Then User should see the homepage
    And profile picture display