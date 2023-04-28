#Facebook, LinkedIn, Twitter, Instagram icons should be visible
#Facebook, LinkedIn, Twitter, Instagram icons should be clickable
#After clicking the Facebook, LinkedIn, Twitter, Instagram icons, the company-related pages should be visible.

Feature: US006

  @US006
  @UI
  Scenario:
    Given user goes to homepage
    Then user verifies social media icons are visible
    Then user verifies social media icons are clickable
    Then user verifies related pages are visible
      | https://www.facebook.com/people/Hyrai/100066951219275/ |
      | https://twitter.com/Hyrai7                             |
      | https://www.linkedin.com/company/hyraicorp/            |