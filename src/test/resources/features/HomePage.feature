@web
  Feature: Home page feature

    Background:
      Given I am on darksky home page

      @verifyHighAndLow
      Scenario: Verify lowest and highest temperature
        When I click on today button to extend it
        And I check lowest and highest temperature on the page
        Then I verify lowest and highest temperature on the page



