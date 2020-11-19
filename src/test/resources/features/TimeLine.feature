@web
  Feature: Homepage feature

    Background:
      Given Verify timeline is displayed in correct format

      @timezone
      Scenario: Verify timeline and timezone
        When I enter city into search text field on home screen
        And I verify city’s time zone
        Then I verify timeline is displayed with two hours incremented