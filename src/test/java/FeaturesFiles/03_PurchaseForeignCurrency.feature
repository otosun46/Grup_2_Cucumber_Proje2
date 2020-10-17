Feature: Functionality of purchase foreing currency

  Background: Login
    Given Navigate to webappsecurity
    When Enter username and password, click Login button

  Scenario Outline:
    When Click Paybill and purchase foreing currency
    And Select currency "<Currency>" and enter amount as "<Amount>"
    Then Choose whether the currency will be "<DollarSelected>" and calculated
    Then Success message shuld be diplayed


    Examples:
      | Currency | Amount | DollarSelected |
      | Sweden   | 100    | dollar         |
      | Norway   | 200    |                |
      | Euro     | 300    | dollar         |