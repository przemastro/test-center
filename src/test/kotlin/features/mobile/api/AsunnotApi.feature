Feature: Apartments Api

  @apiTest
  Scenario: Apartments search count as anonymous
    Given I send "GET" request to "/api/v1/apartments/search/count?type=1" endpoint
    Then I get status code "200"

  @apiTest
  Scenario Outline: Apartments saved search
    Given I send "GET" request authenticated with "<login>" and "<password>" credentials to "/api/v1/apartments/saved_searches?all=1" endpoint
    Then I get status code "<code>"
    And I verify response does not contain duplicates
  Examples:
    | login                  | password | code |
    | oikotietest1@gmail.com | test1234 | 200  |
    | oikotietest1@gmail.com | test1239 | 401  |

  @apiTest
  Scenario Outline: Apartments search list as anonymous with filters
    Given I send "GET" request to "/api/v1/apartments/search/" endpoint with parameters "<parameters>"
    Then I get status code "200"
    And I verify count is not equal 0
  Examples:
      | parameters                                        |
      | count?type=1&locations[]=64,6,Helsinki,%20Uusimaa |

  @apiTest
  Scenario: Apartments search list
    Given I send "GET" request to "/api/v1/apartments/search?page=1&pageSize=26&recommendations=true&type=1&sortBy=2&saveToHistory=true" endpoint
    Then I get status code "200"

  @apiTest
  Scenario Outline: Like/Dislike an apartment
    Given I send "<method>" request authenticated with "<login>" and "<password>" credentials to "/api/v1/apartments/favorites/15612078" endpoint
    Then I get status code "<code>"
    Examples:
      | login                  | password | code |  method  |
      | oikotietest1@gmail.com | test1234 | 200  |    PUT   |
      | oikotietest1@gmail.com | test1239 | 401  |    PUT   |
      | oikotietest1@gmail.com | test1234 | 200  |  DELETE  |
      | oikotietest1@gmail.com | test1239 | 401  |  DELETE  |

  @apiTest
  Scenario Outline: Filter apartments search
    Given I send "GET" request authenticated with "<login>" and "<password>" credentials to "/api/v1/apartments/search?page=1&pageSize=26&recommendations=true&type=1&filter=2&sortBy=2" endpoint
    Then I get status code "<code>"
    Examples:
      | login                  | password | code |
      | oikotietest1@gmail.com | test1234 | 200  |
      | oikotietest1@gmail.com | test1239 | 401  |

  @apiTest
  Scenario Outline: Sort apartments search
    Given I send "GET" request authenticated with "<login>" and "<password>" credentials to "/api/v1/apartments/search?page=1&pageSize=26&recommendations=true&type=1&sortBy=4&saveToHistory=true" endpoint
    Then I get status code "<code>"
    Examples:
      | login                  | password | code |
      | oikotietest1@gmail.com | test1234 | 200  |
      | oikotietest1@gmail.com | test1239 | 401  |