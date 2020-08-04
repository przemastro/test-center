Feature: Jobs Api

  @apiTest
  Scenario: Jobs search count as anonymous
    Given I send "GET" request to "/api/v1/jobs/search/count" endpoint
    Then I get status code "200"

  @apiTest
  Scenario Outline: Jobs saved search
    Given I send "GET" request authenticated with "<login>" and "<password>" credentials to "/api/v1/jobs/saved_searches" endpoint
    Then I get status code "<code>"
    And I verify response does not contain duplicates
  Examples:
    | login                  | password | code |
    | oikotietest1@gmail.com | test1234 | 200  |
    | oikotietest1@gmail.com | test1239 | 401  |

  @apiTest
  Scenario: Jobs search list as anonymous
    Given I send "GET" request to "/api/v1/jobs/search/?page=1&pageSize=25" endpoint
    Then I get status code "200"

  @apiTest
  Scenario Outline: Like/Dislike job
    Given I send "<method>" request authenticated with "<login>" and "<password>" credentials to "/api/v1/jobs/favorites/877319" endpoint
    Then I get status code "<code>"
    Examples:
      | login                  | password | code |  method  |
      | oikotietest1@gmail.com | test1234 | 200  |    PUT   |
      | oikotietest1@gmail.com | test1239 | 401  |    PUT   |
      | oikotietest1@gmail.com | test1234 | 200  |  DELETE  |
      | oikotietest1@gmail.com | test1239 | 401  |  DELETE  |

  @apiTest
  Scenario Outline: Sort jobs search
    Given I send "GET" request authenticated with "<login>" and "<password>" credentials to "/api/v1/jobs/search?page=1&pageSize=25&sortOrder=2&sortCriteria=2" endpoint
    Then I get status code "<code>"
    Examples:
      | login                  | password | code |
      | oikotietest1@gmail.com | test1234 | 200  |
      | oikotietest1@gmail.com | test1239 | 401  |

  @apiTest
  Scenario Outline: View job
    Given I send "PUT" request authenticated with "<login>" and "<password>" credentials to "/api/v1/user/viewed/jobs/879132" endpoint
    Then I get status code "<code>"
    Examples:
      | login                  | password | code |
      | oikotietest1@gmail.com | test1234 | 200  |
      | oikotietest1@gmail.com | test1239 | 401  |