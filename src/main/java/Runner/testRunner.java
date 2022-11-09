package Runner;


import factories.BrowserFactory;
import factories.DriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = "src/main/java/features",
        glue={"Step"},
        plugin = {
                "pretty","html:target/HtmlReports.html"
        }
)

//plugin = {"pretty","json:target/HtmlReports.json"}) to make report on json file
//plugin = {"pretty","junit:target/HtmlReports.xml"})to make report on xml file

public class testRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @Parameters("browserType")
    @BeforeMethod
    public void setupBrowser(String chrome) {
        BrowserFactory bf = new BrowserFactory();

        DriverFactory.getInstance().setDriver(bf.launchBrowser("headless chrome"));
        WebDriver webDriver = DriverFactory.getInstance().getDriver();
        webDriver.manage().window().maximize();
    }

    @AfterMethod
    public void teardownBrowser() {
        DriverFactory.getInstance().closeBrowser();
    }
}
