Feature: List favorites


  Background:
    Given x-api-key is already acquired.


  @favs
  Scenario: Listing for all favorites dogs
    When Tester makes "favorite" request
    Then Tester should see information about dog


  Scenario Outline: user Listing for all favorites dogs of users
    When I make favourite request with <sub_id> parameter
    Then User should see its favourite
    Examples:
    |sub_id|
    |my-user-1234|
    |your-user-1234|


  @votes
  Scenario: Listing for all votes
    When Tester makes votes request
    Then Tester should see votes


