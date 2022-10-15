@SmokeScenario
Feature: Login
  This gherkin for login step positive and negative case

  @SmokeTest
    @negative @login_with_incorrect_format_email
  Scenario Outline: User Login with incorrect format email
    Given User should be input "<url>"
    * User input data username "<username>" and "<password>"
    When User click button login
    Then will showing message error invalid credential

    Examples:
      | url                                                                | username | password |
      | https://opensource-demo.orangehrmlive.com/web/index.php/auth/login | admin1   | admin1   |
      | https://opensource-demo.orangehrmlive.com/web/index.php/auth/login | admin    | admin1   |

  @positive @login_with_correct_credential
  Scenario Outline: User login with correct credential
    Given User should be input "<url>"
    * User input data username "<username>" and "<password>"
    When User click button login
    Then User will move to homepage with account login

    Examples:
      | url                                                                | username | password |
      | https://opensource-demo.orangehrmlive.com/web/index.php/auth/login | Admin    | admin123 |

