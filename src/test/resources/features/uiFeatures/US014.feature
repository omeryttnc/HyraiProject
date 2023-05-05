#As a user, I should be able to see the contact information when I click contact. When I want to send a message, fill in the required fields and I should be able to successfully send a message to the system
#   1-The user should be able to read the address and contact information
#	2-You should fill in the required fields to write a message, and receive a warning if you do not fill them in.
#	3-The name part should only consist of letters and no spaces.
#	4-Surname part should consist of only letters and no spaces
#	5-email id is "@" and "." should contain the system should warn if the user does not use them
#	6-send message must be clickable. Notification about message when user clicks. The system should send the message "your message has been sent successfully

Feature: US014

  Background:
    Given user goes to homepage
    When user clicks on For Companies button
    And user clicks on Contact at the bottom of the page

  @UI
  Scenario: TC001 - negative scenario
    Then user verifies address and contact information are visible
    When user fills out the contact us form
#      | fn | ln | email | subj | message | #message | messages |
      | \n | \n | \n          | \n | \n | 5 | This field is required                                              |
      | a  | \n | \n          | \n | \n | 5 | This field is required,Must be at least 2 characters                |
      | 2  | a  | sd          | \n | \n | 5 | This field is required,Must be at least 2 characters,Invalid e-mail |
      | aa | aa | \n          | \n | \n | 3 | This field is required                                              |
      | \n | \n | sfsaf@dfdsf | \n | \n | 5 | This field is required,Invalid e-mail                               |

  @UI
  Scenario: TC002 - positive scenario
    When user fills out the contact us form successfully
    Then user verifies toast message is visible