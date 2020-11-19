@web
  Feature: Loginpage feature

    Background:
      Given I am on the darksky login page

    @login
    Scenario: Verify error message
      When I enter abc@gmail.com into email text fields on login page
      And I enter password1 into password text fields on login page
      And I click on login button
      Then I verify error message “password and username does not match”