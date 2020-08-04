Feature: Jobs Page

  @smokeTest
  Scenario: Navigate to Jobs page from different locations
    Given I see 'HAE OIKOTIELTÄ' title on Sinulle
    When I click 'TYÖPAIKAT' button
    And I see 'HAE TYÖPAIKKAA' title on Työpaikat page
    Then I go back to previous page
    And I see 'HAE OIKOTIELTÄ' title on Sinulle
    When I click bottom tab 'Haku' button
    Then I see 'HAE OIKOTIELTÄ' title on Haku
    And I click 'TYÖPAIKAT' button
    #And I see 'HAE TYÖPAIKKAA' title on Työpaikat page
    Then I go back to previous page
    And I see 'HAE OIKOTIELTÄ' title on Haku
    And I click bottom tab 'Sinulle' button