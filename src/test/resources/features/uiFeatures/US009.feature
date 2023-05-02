Feature: Candidate Home Page

  @UI
  Scenario: As a user, when I enter the company page web elements at the top must be clickable
    Given user goes to company page

    When user click on logo
    Then assert link is "https://hyrai.com/"

    When user click on home icon
    Then assert link is "https://hyrai.com/"

    When user click on about
    Then assert link is "https://hyrai.com/about-us"

    When user click on contact us
    Then assert link is "https://hyrai.com/contact-us"

    When user click on for companies
    Then assert link is "https://hyrai.com/company"

    When user click on sign up
    Then assert link is "https://hyrai.com/company/auth?tab=SIGN_UP"

    When user click on login
    Then assert link is "https://hyrai.com/company/auth?tab=SIGN_IN"

  @UI
  Scenario: As a user, when I enter the company page web elements at the top must be clickable 2
    Given user goes to company page
    When user click on then assert
      | 0 | "https://hyrai.com/"                         |
      | 1 | "https://hyrai.com/"                         |
      | 2 | "https://hyrai.com/about-us"                 |
      | 3 | "https://hyrai.com/contact-us"               |
      | 4 | "https://hyrai.com/company"                  |
      | 5 | "https://hyrai.com/company/auth?tab=SIGN_UP" |
      | 6 | "https://hyrai.com/company/auth?tab=SIGN_IN"  |






