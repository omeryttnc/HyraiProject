Feature: Login

#
#  Rule: bullet point 1 test
#    Background: goto test sayfasina gidecegi
#      Given user goesto test page


    @smoke
    @login
    Scenario: is user able to login version 1
      Given Step Definition icinde user and password


    @UI
    @smoke
    @login
    @headless
    Scenario: is user able to login version 2
      Given Scenariom icinde "user1" and 3 ve 4.6 "false"

    @UI
    @firefox
    Scenario: is user able to login version 3
      Given Configuration properties kullanarak

#  Rule: bullet point 2 canli
#
#    Background: goto test sayfasina gidecegi
#      Given user goesto production page
    @DB
    Scenario: is user able to login version 4
      Given Enum kullanarak


    Scenario Outline: is user able to login version 5
      Given Scenariom Outline "<username>" and <rakam> <kusurat> "<dogru>"
      Then bir basamak daha olsa <rakam>
      Examples: user info lari
        | username | rakam | kusurat | dogru |
        | user1    | 1     | 2.5     | true  |
        | user2    | 2     | 3.5     | false |



    @smoke
    @login
    Scenario: is user able to login version 6
      Given Data table kullanarak
        | user1 | password1 |
        | user2 | password2 |
      Then bir basamak daha olsa



  @company
    @UI
    @omer
    @smoke
    @login
    Scenario: is user able to login version 7
      Given tag kullanarak




