Feature: Company Sign in

  @UI
    @week3
  Scenario Outline: US 20
    Given user goes to company sign up page
    When user click on forgot password link
    Then user is able to see the text "Please verify your Email" should be displayed
    And Verify email button should be visible
    When a valid "<email>" address is entered
    Then  assert toast message "<email>" if "<isPass>" "Email verification was successful, please check your e-mail address." "Whooops... Something went wrong." Text must be visible
    Examples: mail degerleri
      | email                | isPass |
      | demokesif1@gmail.com | true   |
      | demo_corp@hyrai.com  | true   |
      | demodsdf@gmail.com   | false  |
      | demodsdfgmail.com    | false  |
      | demodsdf@.com        | false  |
      | demodsdf@com         | false  |
