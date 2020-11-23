Feature: Find Transactions in Account Activity


  Scenario Outline: Search date range

    Given the user is logged in
    Given the user navigates to "Account Activity" and "Find Transactions" tab
    When  the user enters date range from "<fromDate>" to "<toDate>"
    And   clicks search
    Then  results table	should only	show transactions dates	between "<fromDate>" to "<toDate>"
    #And   the results should be sorted by most recent date


    Examples:
      | fromDate   | toDate     |
      | 2012-09-01 | 2012-09-06 |
      | 2012-09-02 | 2012-09-06 |


  @done
  Scenario Outline: Search description

    Given the user is logged in
    Given the user navigates to "Account Activity" and "Find Transactions" tab
    When  the user enters description "<description>"
    And   clicks search
    Then  results table	should only	show descriptions containing "<description>"

    Examples:
      | description |
      | ONLINE      |
      | OFFICE      |


  Scenario Outline: Search description case insensitive

    Given the user is logged in
    Given the user navigates to "Account Activity" and "Find Transactions" tab
    When the user enters description "<description>"
    And clicks search
    Then results table	should only	show descriptions containing "<description>"


    Examples:
      | description |
      | ONLINE      |
      | online      |


  Scenario Outline: Type

    Given the user is logged in
    Given the user navigates to "Account Activity" and "Find Transactions" tab
    And clicks search
    Then results table should show at least	one	result under "<dep>"
    Then results table should show at least	one	result under "<with>"
    When user selects type "<dep>"
    And clicks search
    Then results table should show at least	one	result under "<dep>"
    But  results table should show no result under "<with>"
    When user selects type "<with>"
    And clicks search
    Then results table should show at least	one	result under "<with>"
    But  results table should show at least	one	result under "<dep>"


    Examples:
      | dep     | with       |
      | Deposit | Withdrawal |
