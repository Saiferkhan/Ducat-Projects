Feature: Logout feature

Scenario: Validate the logout functionality
	Given User login to the application
	When Click on the profile picture
	And Click on the logout
	Then User logout the apps
	And back to the login page
