Feature: US 27
@UI
  @week4
  @firefox
  @headless
  Scenario Outline: Us 27
    Given user goes to company login page
    When user use "<email>" and "<password>" to login
    Then if user has "<wrong>" credentials will get "<errorMessage>"
    Examples:
      | email                | password | wrong | errorMessage       |
      | demokesif1@gmail.com | 1231232  | true  | Wrong Credentials! |
      | demokesif@gmail.com  | 123123   | true  | Wrong Credentials! |
      | ddemokesif@gmail.com | 131235    | true  | Wrong Credentials! |
      | demokesif1@gmail.com | 123123   | false |                    |



#  1-User must login with valid e-mail and password.
#  2-User should not login with invalid e-mail. Email or password is not valid! warning should be received
#  3-The user should not log in with an invalid password. Email or password is not valid! warning should be received

#  Scenario: US 27 forgot password
#    When user click on forgot password link





#  4-The system should give an option to reset the password when the user uses wrong credentials. Forgot Password option must be active