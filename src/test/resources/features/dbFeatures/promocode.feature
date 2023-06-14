Feature: Promocode

  @DB
  Scenario: create promocode 1
    Given create promocode by using statement

  @DB
  Scenario: update promocode 1
    Given update promocode by using statement

  @DB
  Scenario: delete promocode 1
    Given delete promocode by using statement

  @DB
  Scenario: create promocode 2
    Given create promocode by using prepared statement

  @DB
  Scenario: update promocode 2
    Given update promocode by using prepared statement

  @DB
  Scenario: delete promocode 2
    Given delete promocode by using prepared statement

  @DB
  Scenario: select promocode 1
    Given select promocode


  @DB
  Scenario: select promocode 2
    Given select promocode inner

