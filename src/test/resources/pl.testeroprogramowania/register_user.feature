Feature: Registering a new user
  Scenario: Registering new user with unique email address
    Given User with unique email
    When User register itself
    Then User is redirected to the logged user's page
  Scenario: Registering user with already used email
    Given User with email already registered in database
    When User register itself
    Then Error message informing about already registered email appears