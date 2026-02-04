Feature: User can login with valid data
and user can logout after login only.

Background:
Given User is on the login Application
And Verify the login details

Scenario: User verify the login page
And  User verify login details carefully

Scenario: User logged out the page
When User Click on Profile
And  User click on logout button
Then User should logged out page
And User should see homepage