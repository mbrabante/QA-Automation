@Brand
Feature: Brand > Edit Brand

  @EBTC001
  Scenario: Successfully edited the brand
    Given User created a new brand
    When User search the created brand from Brand page
    And Update the brand with valid new Brand Name
    Then Brand is updated successfully