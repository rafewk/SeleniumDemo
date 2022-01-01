Feature: Logging into application

  Background:
    Given User is at My Account Page

  Scenario: User logs into app using valid name and password
    When User logs in with valid data
    Then User is redirected to the logged user's page
