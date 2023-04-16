Feature: Login

  @company
  @UI
  @omer
  @smoke
  @login
  Scenario: is user able to login version 1
    Given tag kullanarak


  @UI
  Scenario Outline: is user able to login version 2

    Given Scenario Outline "<username>" and "<password>"
    Examples: user info lari
      | username | password  |
      | user1    | password1 |
      | user2    | password2 |


  @UI
  Scenario: is user able to login version 3
    Given Configuration properties kullanarak


  @UI
  Scenario: is user able to login version 4
    Given Enum kullanarak


  @UI
  @omer
  @smoke
  @login
  Scenario: is user able to login version 5
    Given Data table kullanarak
      | user1    | password1 |
      | user2    | password2 |


  @UI
  @omer
  @smoke
  @login
  Scenario: is user able to login version 6
    Given Scenario icinde "user1" and "password1"



