package Step;

import Page.loginPage;
import Page.personalDetailPage;
import factories.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seleniumHelper.SeleniumHelper;

public class personalDetailStep {

    WebDriver webDriver = DriverFactory.getInstance().getDriver();

    personalDetailPage personal = new personalDetailPage(webDriver);

    SeleniumHelper helper = new SeleniumHelper(webDriver);

    @Given("User go to homepage")
    public void user_go_to_homepage() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        webDriver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginStep login = new loginStep();
        login.user_input_data_username_and("Admin","admin123");
        login.user_click_button_login();
    }
    @Given("User go to menu {string}")
    public void user_go_to_menu(String string) {
        // Write code here that turns the phrase above into concrete actions
        personal.btnInfo();
        helper.waitUntilElementIsClickable(webDriver.findElement(By.xpath("//span[.='My Info']")));
    }

    @When("User click {string}")
    public void user_click(String string) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        personal.btnDetail();
        helper.waitUntilElementIsClickable(webDriver.findElement(By.xpath("//a[.='Personal Details']")));
    }
    @Then("User should be able to see Personal detail page")
    public void user_should_be_able_to_see_personal_detail_page() {
        // Write code here that turns the phrase above into concrete actions
        personal.pageInfo();
    }

}
