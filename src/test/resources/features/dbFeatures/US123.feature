#DB	US_123	As a user, when i should sign up then Should be able to see new user information in the correct user schema and columns	Database
#
#			Correct infos need to be seen in the correct columns.
#			I should see user informations in the correct columns, eg : email.
Feature: US123
  @UI @DB
  Scenario: tc001
    Given user goes to urbanicfarm register page
    When user fills out the registration form
    And user clicks on the register button
#    Given user connects to the database
    Then user verifies the registered user exists
#    And user closes connection

