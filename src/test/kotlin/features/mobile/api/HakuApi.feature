Feature: Search page Api

  @apiTest
  Scenario Outline: Apartments map pin
    Given I send "GET" request authenticated with "<login>" and "<password>" credentials to "/api/v1/apartments/map_pin_search?viewMinLatitude=52.041899175682865&viewMaxLatitude=52.587984246388956&viewMinLongitude=16.406733973599842&viewMaxLongitude=17.398171249259857&minLatitude=52.041899&maxLatitude=52.587984&minLongitude=16.406734&maxLongitude=17.398171&type=1&pageSize=10000&page=1" endpoint
    Then I get status code "<code>"
  Examples:
    | login                  | password | code |
    | oikotietest1@gmail.com | test1234 | 200  |
    | oikotietest1@gmail.com | test1239 | 401  |


