Feature: Example Api

  @apiTest
  Scenario: Example Api
    Given I send "GET" request to "https://example" url and "/api/endpoint" endpoint
    Then I get status code "200"
