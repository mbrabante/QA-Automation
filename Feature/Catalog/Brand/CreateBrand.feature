@Brand
Feature: Create New Brand
  To test Create New Brand function

  @CBTC001
  Scenario Outline: Test Create Brand with valid details
    Given Navigate to Brand page
    When Click on Create New Brand button
    And Enter valid "<Brand>" details
    And Click on Save button
    Then Successful message is displayed
    And Added to the Brands list

    Examples: 
      | Brand    |
      | 1QABRAND |
