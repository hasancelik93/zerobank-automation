Feature:    Purchase Foreign Currency

  Background:
    Given the user is logged in
    Given the user navigates to "Pay Bills" and "Purchase Foreign Currency" tab

  Scenario:Available currencies


    Then  following	currencies should	be	available
      | Australia (dollar) |
      | Canada (dollar)    |
#      | Switzerland (franc)   |
#      | China (yuan)          |
#      | Denmark (krone)       |
#      | Eurozone (euro)       |
#      | Great Britain (pound) |
#      | Japan (yen)           |
#      | Mexico (peso)         |
#      | Norway (krone)        |
#      | New Zealand (dollar)  |
#      | Singapore (dollar)    |

  @wip
  Scenario Outline:Error message for not selecting "<data>"

    When  user tries to calculate cost without selecting a "<data>"
    Then  error message should be displayed

    Examples:
      | data     |
      | currency |
      | value    |


