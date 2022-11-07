package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class personalDetailPage {

    WebDriver webDriver;

    public personalDetailPage(WebDriver webDriver){
        this.webDriver = webDriver;
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//span[.='My Info']")
    private WebElement btnInfo;

    @FindBy(xpath = "//a[.='Personal Details']")
    private WebElement btnDetail;

    @FindBy(xpath = "//h6[.='Personal Details']")
    private WebElement modalInfo;

    public void btnInfo() {
        btnInfo.click();
    }

    public void btnDetail() {
        btnDetail.click();
    }

    public void pageInfo(){
        boolean isExist = modalInfo.isDisplayed();
        Assert.assertTrue(modalInfo.isDisplayed());
    }

}
