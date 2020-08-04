Feature: Notifications Api

  @apiTest
  Scenario Outline: Notifications
    Given I send "GET" request authenticated with "<login>" and "<password>" credentials to "/api/v1/user/notifications?page=1&pageSize=15" endpoint
    Then I get status code "<code>"
  Examples:
    | login                  | password | code |
    | oikotietest1@gmail.com | test1234 | 200  |
    | oikotietest1@gmail.com | test1239 | 401  |
