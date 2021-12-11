Feature: Search by keyword

  @wiki
  Scenario: Searching for a term
    Given Tester is researching things on the internet
    When he looks up "Cucumber"
    Then he should see information about "Cucumber"
