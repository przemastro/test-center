Feature: Search Page

  @smokeTest
  Scenario: Validate map on Search page
    Given I click bottom tab 'Haku' button
    Then I see 'HAE OIKOTIELTÄ' title on Haku
    When I click Asunnot lahelta map container
    Then I see alert window
    And I click pop up 'EI' button
    Then I see 'HAE OIKOTIELTÄ' title on Haku
    When I click Asunnot lahelta map container
    Then I see alert window
    And I click pop up 'KYLLÄ' button
    Then I click phone 'Back' button
    Then I see 'HAE OIKOTIELTÄ' title on Haku
    And I click bottom tab 'Sinulle' button
