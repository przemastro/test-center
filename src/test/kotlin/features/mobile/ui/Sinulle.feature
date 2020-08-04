Feature: Main Page

    @smokeTest
    Scenario: Validate Favourite icon on Main page
    Given I see 'HAE OIKOTIELTÄ' title on Sinulle
    When I click favourite icon
    Then I see 'TALLENNA SUOSIKKI' screen
    When I click 'Ei Kiitos' button
    And I click favourite icon
    Then I see 'TALLENNA SUOSIKKI' screen
    When I click 'Tallenna' button
    Then I see 'Kirjautumalla saat enemmän' header on Sinulle
    And I click profiili 'Kirjaudu Oikotie-tunnuksilla' button
    Then I type 'test1234' into 'password' field on Profiili
    And I type 'oikotietest1@gmail.com' into 'email' field on Profiili
    And I click profiili 'Jatka' button
    When I click favourite icon
    #Then I see 'Ilmoitus tallennettu suosikkeihin' message
    And I click favourite icon
    #Then I see 'Ilmoitus poistettu suosikeista' message




