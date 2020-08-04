Feature: Saved Data Api

  @apiTest
  Scenario Outline: List of liked apartments and jobs
    Given I send "GET" request authenticated with "<login>" and "<password>" credentials to "/api/v1/apartments/favorites" endpoint
    Then I get status code "<code>"
  Examples:
    | login                  | password | code |
    | oikotietest1@gmail.com | test1234 | 200  |
    | oikotietest1@gmail.com | test1239 | 401  |
