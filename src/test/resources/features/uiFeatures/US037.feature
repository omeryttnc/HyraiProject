# Meeting
#Month and year buttons should be functional
#Year drop-down menu should be functional
#Years in the Year drop-down menu must be in order
#The year seen when the site is opened must be the current year
#Month drop-down menu should be functional
#The months in the Month drop-down menu must be sequential
#The month seen when the site is opened must be the current month
#Today's date must be in a different color on the calendar
#If there is a meeting that has been set before, it should take place on the this date.

Feature:
  @UI
  Scenario:
    Given user logs in as a company
    When user clicks on Meetings
    Then user verifies Month button is functional
    And user verifies Year button is functional
    And user verifies Year dropdown is functional
    And user verifies Month dropdown is functional
    And user verifies years in year dropdown is in order
    And user verifies year dropdown shows current year
    And user verifies months in month dropdown is in order
    And user verifies month dropdown shows current month
    And user verifies calendar shows today's date in different color
    And user verifies scheduled meetings are shown in calendar
    When user clicks on Year button
    Then user verifies current month is shown in different color




