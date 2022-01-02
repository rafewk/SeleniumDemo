Feature: Checkout

  Scenario: Successful checkout

    Given User is at Shop Page
    When User adds a product "GIT basics" to the cart
    And Fills shipping information form
    Then User is redirected to the Order Details Page