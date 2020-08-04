Feature: Profile Page

  Background:
    Given I click bottom tab 'Profiili' button
    And I click Kirjaudu tai luo tunnus button

  @notToRun
  Scenario: Register new oikotie account
    When I click profiili 'Luo uusi Oikotie-tunnus' button
    Then I type 'oikotietest1@gmail.com' into 'email' field on Profiili
    Then I click profiili 'Continue' button
    And I type 'test1234' into 'password' field on Profiili
    Then I click 'Hyvaksyn Oikotien kayttoehdot ja tietosuojalausekkeen' switch
    And I click profiili 'Continue' button

  @smokeTest
  Scenario Outline: Register existing oikotie user
    When I click profiili 'Luo uusi Oikotie-tunnus' button
    Then I type '<login>' into 'email' field on Profiili
    And I click profiili 'clear email' button
    And I type '<login>' into 'email' field on Profiili
    Then I click profiili 'Continue' button
    Then I verify profiili 'Continue' button is disabled
    And I type '<password>' into 'password' field on Profiili
    Then I click profiili 'Hyvaksyn Oikotien kayttoehdot ja tietosuojalausekkeen' switch
    And I click profiili 'Continue' button
    And I verify 'Sähköpostiosoite on jo rekisteröity' message appears on Profiili

  Examples:
      | login                  | password |
      | oikotietest1@gmail.com | test1234 |


  @smokeTest
  Scenario Outline: Log in with oikotie account
    When I click profiili 'Kirjaudu Oikotie-tunnuksilla' button
    And I verify profiili 'Jatka' button is disabled
    Then I type '<password>' into 'password' field on Profiili
    And I verify profiili 'Jatka' button is disabled
    Then I type '<login>' into 'email' field on Profiili
    And I click profiili 'clear email' button
    And I type '<login>' into 'email' field on Profiili
    And I click profiili 'Jatka' button
    Then I click profiili 'menu settings' button
    And I click profiili 'logout' button
    And I click pop up 'PERUUTA' button
    And I click profiili 'logout' button
    And I click pop up 'KIRJAUDO ULOS' button
    Then I click phone 'Back' button
    And I do not see profiili 'menu settings' button

  Examples:
      | login                  | password |
      | oikotietest1@gmail.com | test1234 |


  @todo
  #Scenario: Log in with facebook account
    #When I click profiili 'Kirjaudu Facebook-tunnuksilla' button
    ##And I click CONTINUE on Terms and Privacy Policy page
    #Then I type facebook email 'email'
    #And I type facebook password 'password'
    #And I click 'LOG IN' button
    #And I verify user is logged in
    #Then I click logout button
    #And I click 'KIRJAUDU ULOS' button
    #And I click 'PERUUTA' button in the 'Kirjaudu ulos' pop up
    #And I click 'KIRJAUDU ULOS' button
    #And I click 'JATKA' button in the 'Kirjaudu ulos' pop up
    #And I verify user is logged out
    #And I click 'Ei Kiitos' button
    #And I click 'Sinulle' button

  @smokeTest
  Scenario Outline: Reset oikotie account password
    When I click profiili 'Kirjaudu Oikotie-tunnuksilla' button
    And I verify profiili 'Jatka' button is disabled
    Then I type '<password>' into 'password' field on Profiili
    And I verify profiili 'Jatka' button is disabled
    And I type '<login>' into 'email' field on Profiili
    And I click profiili 'Jatka' button
    Then I click profiili 'menu settings' button
    And I click Vaihda salasana button
    Then I type '<password>' into 'Existing Password' field on Profiili
    And I type '<newPassword>' into 'New Password' field on Profiili
    And I type '<newPassword>' into 'Repeat Password' field on Profiili
    And I click Jatka button on Profiili page
    And I click profiili 'Sulje' button
    And I click profiili 'logout' button
    And I click pop up 'KIRJAUDO ULOS' button
    And I click profiili 'Kirjaudu Oikotie-tunnuksilla' button
    Then I type '<newPassword>' into 'password' field on Profiili
    And I type '<login>' into 'email' field on Profiili
    And I click profiili 'Jatka' button
    Then I click profiili 'menu settings' button
    And I click Vaihda salasana button
    Then I type '<newPassword>' into 'Existing Password' field on Profiili
    And I type '<password>' into 'New Password' field on Profiili
    And I type '<password>' into 'Repeat Password' field on Profiili
    And I click Jatka button on Profiili page
    And I click profiili 'Sulje' button
    And I click profiili 'logout' button
    And I click pop up 'KIRJAUDO ULOS' button

  Examples:
    | login                  | password | newPassword |
    | oikotietest1@gmail.com | test1234 | test2345    |
