Feature: Add payee

  Background: Login
    Given Navigate to webappsecurity
    When Enter username and password, click Login button
#    Then User should login successfully

  Scenario Outline: Add payee
    When Click Paybill and newPayee
    And Send "<PayeName>"to Paye name
    Then Send "<PayeeAddress>"to Payee Address
    Then Send "<Account>"to Account
    Then Send "<PayeeDetails>"to Payee Details
    And  Save to form






    Examples:
      | PayeName | PayeeAddress | Account | PayeeDetails |
      | Orhan    | Swerige      | Save    | 2 nci grup 1 |
      | Sare     | Norge        | Save    | 2 nci grup 2 |
      | Ozge     | Turkiye      | Save    | 2 nci grup 3 |
      | Volkan   | USA          | Save    | 2 nci grup 4 |
      | Akif     | Deutschland  | Save    | 2 nci grup 5 |
