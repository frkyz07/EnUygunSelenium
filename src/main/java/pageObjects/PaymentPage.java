package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage {

    public WebDriver driver;

    By reservationTitle = By.xpath("//div[@class='reservationTitle']/strong");
    By startDate = By.xpath("(//div/span[@data-testid='DepartureFlightDateTime'])[1]");
    By returnDate = By.xpath("(//div/span[@data-testid='DepartureFlightDateTime'])[2]");
    By flightProviderName = By.xpath("//div[@id='flightItemdeparture']//div[@class='airline-name']/span");
    By returnFlightProviderName = By.xpath("//div[@data-testid='flightItemreturn1']//div[@class='airline-name']/span");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement reservationTitle() {
        return driver.findElement(reservationTitle);
    }
    public WebElement startDate() {
        return driver.findElement(startDate);
    }
    public WebElement returnDate() {
        return driver.findElement(returnDate);
    }
    public WebElement flightProviderName() {
        return driver.findElement(flightProviderName);
    }
    public WebElement returnFlightProviderName(){return driver.findElement(returnFlightProviderName);}


}
