Feature: Apartments Api

  @apiTest
  Scenario: Get apartments list as anonymous
    Given I send "GET" request to "https://asunnot.oikotie.fi" url and "/api/cards?cardType=107&limit=24&offset=0&sortBy=published_sort_desc" endpoint
    Then I get status code "200"
