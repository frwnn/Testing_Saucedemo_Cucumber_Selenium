Feature: Logout from Account

Scenario: User can successfully log out

Given the user has successfully logged into the SauceDemo account
And the user is on the account's main page
When the user clicks the Logout button
Then the user successfully logs out and returns to the login page