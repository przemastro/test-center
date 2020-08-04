Feature: Mobile API Performance

  @performance
  Scenario Outline: Mobile API Performance
    Given I send "GET" request authenticated with "<login>" and "<password>" credentials to "/api/v1/user/notifications?page=1&pageSize=15" endpoint
    Then I get response time for "/api/v1/user/notifications" endpoint
    Given I send "GET" request authenticated with "<login>" and "<password>" credentials to "/api/v1/feed/block/1/1?page=1&pageSize=5&params[apt_all]=1" endpoint
    Then I get response time for "/api/v1/feed/block/1/1" endpoint
    Given I send "GET" request to "/api/v1/jobs/search/count" endpoint
    Then I get response time for "/api/v1/jobs/search/count" endpoint
    Given I send "GET" request authenticated with "<login>" and "<password>" credentials to "/api/v1/jobs/saved_searches" endpoint
    Then I get response time for "/api/v1/jobs/saved_searches" endpoint
    Given I send "GET" request to "/api/v1/jobs/search/?page=1&pageSize=25" endpoint
    Then I get response time for "/api/v1/jobs/search" endpoint
    Given I send "GET" request to "/api/v1/apartments/search/count?type=1" endpoint
    Then I get response time for "/api/v1/apartments/search" endpoint
    Given I send "GET" request authenticated with "<login>" and "<password>" credentials to "/api/v1/apartments/saved_searches?all=1" endpoint
    Then I get response time for "/api/v1/apartments/saved_searches" endpoint
    Given I send "GET" request to "/api/v1/apartments/search?page=1&pageSize=26&recommendations=true&type=1&sortBy=2&saveToHistory=true" endpoint
    Then I get response time for "/api/v1/apartments/search" endpoint
    Examples:
      | login                  | password |
      | oikotietest1@gmail.com | test1234 |
