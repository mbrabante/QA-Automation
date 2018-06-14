@Brand
Feature: Brand > Create a New Brand

  @CBTC001
  Scenario: Successful creation of a new brand
    Given User is in Brand module main page
    When User clicks on the Create a New Brand button
    And Populate all the required fields with valid data
    Then New brand is successfully created
    And Added to the Brand list

  @CBTC002
  Scenario: Created an existing brand
    When User clicks on the Create a New Brand button
    And Populate all the required fields using an existing brand
    Then Error message is displayed

  @CBTC003
  Scenario: Required fields are blank
    When User leaves the required fields blank
    Then Error message under the required fields are displayed
