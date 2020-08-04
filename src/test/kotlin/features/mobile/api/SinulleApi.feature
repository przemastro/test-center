Feature: Main page Api

  @apiTest
  Scenario Outline: List on main page
    Given I send "GET" request authenticated with "<login>" and "<password>" credentials to "/api/v1/feed/block/1/1?page=1&pageSize=5&params[apt_all]=1" endpoint
    Then I get status code "<code>"
  Examples:
    | login                  | password | code |
    | oikotietest1@gmail.com | test1234 | 200  |
    | oikotietest1@gmail.com | test1239 | 401  |

  @apiTest
  Scenario Outline: Get all data on main page
    Given I send "GET" request authenticated with "<login>" and "<password>" credentials to "/api/v1/feed/block/1/1?page=1&pageSize=5&params[apt_all]=1" endpoint
    Then I get status code "<code>"
    Examples:
      | login                  | password | code |
      | oikotietest1@gmail.com | test1234 | 200  |
      | oikotietest1@gmail.com | test1239 | 401  |

