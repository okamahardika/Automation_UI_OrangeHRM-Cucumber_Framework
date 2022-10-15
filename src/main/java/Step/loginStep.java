package Step;

import Page.loginPage;
import factories.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class loginStep {

    WebDriver webDriver = DriverFactory.getInstance().getDriver();

    loginPage login = new loginPage(webDriver);


    @Given("User should be input {string}")
    public void user_should_be_input(String url) {
        // Write code here that turns the phrase above into concrete actions
        webDriver.navigate().to(url);
    }

    @Given("User input data username {string} and {string}")
    public void user_input_data_username_and(String username, String password) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        login.Login(username, password);
    }

    @When("User click button login")
    public void user_click_button_login() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        login.btnLogin();
    }

    @Then("will showing message error invalid credential")
    public void will_showing_message_error_invalid_credential() {
        // Write code here that turns the phrase above into concrete actions
        login.errorLogin();
    }

    @Then("User will move to homepage with account login")
    public void user_will_move_to_homepage_with_account_login() {
        // Write code here that turns the phrase above into concrete actions
        login.successLogin();
    }
}
