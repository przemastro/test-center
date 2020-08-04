Feature: Notifications Page

  @smokeTest
  Scenario Outline: Validate buttons on Notifications page for non logged in user
    Given I click bottom tab 'Tapahtumat' button
    Then I see 'TAPAHTUMAT' title on Tapahtumat page
    And I click Kirjaudu tai luo tunnus button
    And I click profiili 'Kirjaudu Oikotie-tunnuksilla' button
    Then I type '<password>' into 'password' field on Profiili
    Then I type '<login>' into 'email' field on Profiili
    And I click profiili 'Jatka' button
    Then I see 'TAPAHTUMAT' title on Tapahtumat page
    And I click 'Kirjaudu tai luo tunnus' button
    And I click return button
    Then I see 'TAPAHTUMAT' title on Tapahtumat page

  Examples:
      | login                  | password |
      | oikotietest1@gmail.com | test1234 |