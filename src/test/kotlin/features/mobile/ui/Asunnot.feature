Feature: Apartments Page

  @smokeTest
  Scenario: Navigate to Apartments page from different locations
    Given I see 'HAE OIKOTIELTÄ' title on Sinulle
    When I click 'ASUNNOT' button
    And I see 'HAE ASUNTOA' title on Asunnot page
    Then I go back to previous page
    And I see 'HAE OIKOTIELTÄ' title on Sinulle
    When I click bottom tab 'Haku' button
    Then I see 'HAE OIKOTIELTÄ' title on Haku
    And I click 'ASUNNOT' button
    And I see 'HAE ASUNTOA' title on Asunnot page
    Then I go back to previous page
    And I see 'HAE OIKOTIELTÄ' title on Haku
    And I click bottom tab 'Sinulle' button
    And I see 'HAE OIKOTIELTÄ' title on Sinulle

  @smokeTest
  Scenario: Verify Most Viewed Apartments details on Main page
    Given I see 'HAE OIKOTIELTÄ' title on Sinulle
    When I click first offer on Sinulle
    Then I see 'OTA YHTEYTTÄ' button on Asunnot
    And I click 'Kohteen tiedot' tab on Asunnot
    And I scroll to the top of the page
    And I click 'Hintatiedot' tab on Asunnot
    And I scroll to the top of the page
    #And I click 'Palvelut' tab on Asunnot
    #And I scroll to the top of the page
    When I click asunnot 'OTA YHTEYTTÄ' button
    Then I see 'OTA YHTEYTTÄ' title on Ota Yhteytta page
    When I click laheta viesti icon button
    Then I see 'LÄHETÄ VIESTI' title on Laheta Viesti
    When I click return button
    Then I see 'OTA YHTEYTTÄ' title on Ota Yhteytta page
    When I click X button
    Then I see 'OTA YHTEYTTÄ' button
    When I click return button
    Then I see 'HAE OIKOTIELTÄ' title on Sinulle

  @smokeTest
  Scenario: Verify Most Viewed Apartments top buttons on Main page
    Given I see 'HAE OIKOTIELTÄ' title on Sinulle
    When I click 'ASUNNOT' button
    Then I see 'HAE ASUNTOA' title on Asunnot page
    When I click asunnot 'NAYTA HAKUTULOKSET' button
    And I click first offer
    And I click favourite icon on the top right
    Then I click popup 'Ei Kiitos' button
    When I click on share symbol on the top right
    #Then I see share 'Jaa asunto' title
    When I click phone 'Back' button
    And I go back to previous page
    And I go back to previous page
    #And I see 'HAE ASUNTOA' title on Asunnot page
    And I go back to previous page
    Then I see 'HAE OIKOTIELTÄ' title on Sinulle