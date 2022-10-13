Feature: Search on booking.com
  This is description
  Scenario: Name and hotel rating should be correct after search (Dubai)
    Given User is on the search page
    When User searches for "Dubai"
    Then Hotel name is "Grand Cosmopolitan Hotel"
    And Hotel rating is "9,1"