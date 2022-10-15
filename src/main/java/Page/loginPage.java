package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class loginPage {

    WebDriver webDriver;

    public loginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement txtUsername;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement txtPassword;

    @FindBy(xpath = "//div[@class='oxd-form-actions orangehrm-login-action']")
    private WebElement btnLogin;

    @FindBy(xpath = "//div[@class='oxd-alert-content oxd-alert-content--error']")
    private WebElement txtError;

    @FindBy(xpath = "//div[@class='oxd-topbar-header-title']")
    private WebElement modalLogin;

    public void Login(String username, String password){
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
    }

    public  void btnLogin() throws InterruptedException {
        btnLogin.click();
        Thread.sleep(3000);
    }
    public void successLogin(){
        Boolean isExist =modalLogin.isDisplayed();
        Assert.assertTrue(modalLogin.isDisplayed());
    }

    public void errorLogin(){
        Boolean isExist = txtError.isDisplayed();
        Assert.assertTrue(txtError.isDisplayed());
    }
}
