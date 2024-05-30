Feature: Example Api Tests

  @apiTest
  Scenario: Example Api Test
    Given I send "GET" request to "/api/v1/example" endpoint
    Then I get status code "200"
