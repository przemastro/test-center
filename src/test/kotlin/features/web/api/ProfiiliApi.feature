Feature: Profiili Api

  @apiTest
  Scenario Outline: Login with Oikotie account
    Given I send "POST" request authenticated with "<login>" and "<password>" credentials to "https://sso.oikotie.fi" url and "/client/v2/login" endpoint
    #Given I send "POST" request to "https://sso.oikotie.fi" url and "/client/v2/login" endpoint with body "type=ot,password=test1234,user=oikotietest1@gmail.com"
    Then I get status code "<code>"
  Examples:
      | login                  | password | code |
      | oikotietest1@gmail.com | test1234 | 200  |


