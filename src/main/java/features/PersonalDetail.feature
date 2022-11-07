Feature: Cek personal detail
  This test cases is to make sure personal data user shown on web

  @positive
  Scenario: User should be able to see detail info
    Given User go to homepage
    * User go to menu "My Info"
    When User click "Personal Detail"
    Then User should be able to see Personal detail page