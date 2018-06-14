Feature: Admin Login

  @TC001
  Scenario: Test Login page of Admin Portal
    Given User launched the Admin Portal
    When User enter valid username and password
    Then Admin page is displayed
