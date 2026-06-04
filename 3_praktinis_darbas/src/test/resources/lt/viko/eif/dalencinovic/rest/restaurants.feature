Feature: Restaurants data navigation
  User want to see the restaurants data

  Scenario: Display list of all restaurants
    Given new restaurant added to the system
    When user navigates to restaurants list
    Then restaurant list should contain 1 restaurant