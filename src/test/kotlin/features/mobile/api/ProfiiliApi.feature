Feature: Profiili Api

  @apiTest
  Scenario: Register existing oikotie account
    Given I send "POST" request to "/api/v1/user/register" endpoint with body "type=ot,password=test1234,user=oikotietest1@gmail.com"
    Then I get status code "401"

  @apiTest
  Scenario Outline: Reset oikotie password
    Given I send "POST" request authenticated with "<login>" and "<password>" credentials to "/api/v1/user/resetpw" endpoint with body "user=oikotietest1@gmail.com"
    Then I get status code "<code>"
  Examples:
      | login                  | password | code |
      | oikotietest1@gmail.com | test1234 | 200  |
      | oikotietest1@gmail.com | test1239 | 401  |

  @apiTest
  Scenario Outline: Change oikotie password
    Given I send "POST" request authenticated with "<login>" and "<password>" credentials to "/api/v1/user/changepw" endpoint with body "new_password=test1234,old_password=test1234"
    Then I get status code "<code>"
    Examples:
      | login                  | password | code |
      | oikotietest1@gmail.com | test1234 | 200  |
      | oikotietest1@gmail.com | test1239 | 401  |

  @todo
  Scenario: Login with facebook account
    Given I send "POST" request to "/api/v1/user/fb_login" endpoint
    Then I get status code "<code>"