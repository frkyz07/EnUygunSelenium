package src.test.Academy;

import base.Base;
import base.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.FlightsPage;
import pageObjects.HomePage;
import pageObjects.PaymentPage;

import java.io.IOException;

public class BaseTest extends Base {

    static WebDriver driver;
    static WebDriverWait wait;
    static HomePage homePage;
    static FlightsPage flightsPage;
    static PaymentPage paymentPage;
    static Helper helper;


    @BeforeClass
    public WebDriver initialize() throws IOException {
        driver = initializeDriver();
        helper = new Helper(driver);
        driver.get(helper.conReader("url"));
        return this.driver;
    }

}
