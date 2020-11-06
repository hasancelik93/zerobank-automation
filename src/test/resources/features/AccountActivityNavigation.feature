Feature: Navigating to specific accounts in Accounts Activity


  Scenario Outline: "<link>" account redirects

    Given the user is logged in
    When the user clicks on "<link>" link on the Account Summary page
    Then the "Zero - Account Activity" should be displayed
    And Account drop down should have "<link>" selected



    Examples:
      | link        |
      | Savings     |
      | Brokerage   |
      | Checking    |
      | Credit Card |
      | Loan        |