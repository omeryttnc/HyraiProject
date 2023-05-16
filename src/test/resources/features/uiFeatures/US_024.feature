Feature: Candidate Sign in

  @UI
  @week4
  @headless
  Scenario: US 24
    When user customer sign Up page
    Then name should be visible.
    When user send one letter like "a" . "❗ Must be at least 2 characters" (warning text when letter length does not match)
    Then last Name must be visible.
    When user send user send one letter like "a" . "❗ Must be at least 2 characters" (warning text when letter length does not match)
    Then The text Email must be visible.
    * Email should except proper email
      | email                    | isAccepted | message          |
      | abc..def@mail.com        | false      | ❗ Invalid e-mail |
  #    | abc-@mail.com            | false      | ❗ Invalid e-mail |
      | .abc@mail.com            | false      | ❗ Invalid e-mail |
  #   | abc#def@mail.com         | false      | ❗ Invalid e-mail |
      | abc-d@mail.com           | true       |                  |
      | abc.def@mail.com         | true       |                  |
      | abc@mail.com             | true       |                  |
      | abc_def@mail.com         | true       |                  |
    #  | abc.def@mail.c           | false      | ❗ Invalid e-mail |
      | abc.def@mail#archive.com | false      | ❗ Invalid e-mail |
      | abc.def@mail             | false      | ❗ Invalid e-mail |
      | abc.def@mail..com        | false      | ❗ Invalid e-mail |
      | abc.def@mail.cc          | true       |                  |
      | abc.def@mail-archive.com | true       |                  |
      | abc.def@mail.org         | true       |                  |
      | abc.def@mail.com         | true       |                  |
      | omeryttnc@.com           | false      | ❗ Invalid e-mail |
      | @gmail.com               | false      | ❗ Invalid e-mail |
      | omeryttnc@gmail.com      | true       |                  |
    # a-z 0-9 .
# https://help.xmatters.com/ondemand/trial/valid_email_format.htm#:~:text=A%20valid%20email%20address%20consists,com%22%20is%20the%20email%20domain.
    * Password must be visible.
    When user send password less than six characters like "abc". "❗ Must be at least 6 characters" (warning text when characters length does not match)
    *  The text Confirm Password should be visible.
    *  "Your personal data will be used to support your experience throughout this website, to manage access to your account, and for other purposes described in our privacy policy." text must be visible.
    * The "Sign Up as a Company" button must be active. When I click it, I should see "Company" in the sign up window.