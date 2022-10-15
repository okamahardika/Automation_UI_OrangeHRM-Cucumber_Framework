package factories;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private static DriverFactory instance  = new DriverFactory();


//  this class implements java design pattern singleton
    public static DriverFactory getInstance() {
        return instance;
    }

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();


    public WebDriver getDriver() {
        return driver.get();
    }

    public void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }

    public void closeBrowser() {
            driver.get().close();
            driver.remove();
    }
}
