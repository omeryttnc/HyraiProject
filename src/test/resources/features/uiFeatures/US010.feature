Business Need: Learn more Should work as expected

  @UI
  Scenario: US 010
    Given user goes to company page
    Then assert appropriate warning appears


      |      | company | title | abcdefghijk | omeryttnc@gmail.com | ❗ This field is required                                    | false |
      | a    | company | title | abcdefghijk | omeryttnc@gmail.com | ❗ Must be at least 2 characters                             | false |
      | name |         | title | abcdefghijk | omeryttnc@gmail.com | ❗ This field is required                                    | false |
      | name | c       | title | abcdefghijk | omeryttnc@gmail.com | ❗ Must be at least 2 characters                             | false |
      | name | company |       | abcdefghijk | omeryttnc@gmail.com | ❗ This field is required                                    | false |
      | name | company | t     | abcdefghijk | omeryttnc@gmail.com | ❗ Must be at least 2 characters                             | false |
      | name | company | title |             | omeryttnc@gmail.com | ❗ This field is required                                    | false |
      | name | company | title | ab          | omeryttnc@gmail.com | ❗ Must be at least 10 characters                            | false |
      | name | company | title | abcdefghijk |                     | ❗ This field is required                                    | false |
      | name | company | title | abcdefghijk | omeryttncgmail.com  | ❗ Invalid e-mail                                            | false |
      | name | company | title | abcdefghijk | omeryttnc@gmailcom  | ❗ Invalid e-mail                                            | false |
#      | name | company | title | abcdefghijk | omeryttnc@gmail.c   | ❗ Invalid e-mail                 | false |
      | name | company | title | abcdefghijk | omeryttnc@.com      | ❗ Invalid e-mail                                            | false |
      | name | company | title | abcdefghijk | @gmail.com          | ❗ Invalid e-mail                                            | false |
      | name | company | title | abcdefghijk | omeryttnc@gmail.com | Your request has been submit.We will contact to you soon .. | true  |