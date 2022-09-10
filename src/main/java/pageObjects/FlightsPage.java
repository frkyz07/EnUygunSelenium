package pageObjects;

import base.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class FlightsPage {

    public WebDriver driver;


    String provider = ConfigReader.getProperty("provider");
    By originFlightPicker = By.xpath("(//div[contains(@data-booking-provider,'"+provider+"')])[1]");
    By returnFlightPicker = By.xpath("(//div[contains(@data-booking-provider,'"+provider+"')])[2]//div[@class='flight-summary-radio']");
    By packagePicker = By.xpath("//div[@data-package-provider='tuned_price,direct_flight_data']//button");
    By startFlightProvider = By.xpath("(//div/img[@class='airline-icon'])[1]");
    By returnFlightProvider = By.xpath("(//div/img[@class='airline-icon'])[2]");

    public FlightsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement originFlightPicker() {
        return driver.findElement(originFlightPicker);
    }

    public WebElement returnFlightPicker() {
        return driver.findElement(returnFlightPicker);
    }

    public WebElement packagePicker() {
        return driver.findElement(packagePicker);
    }
    public WebElement startFlightProvider() {
        return driver.findElement(startFlightProvider);
    }
    public WebElement returnFlightProvider() {
        return driver.findElement(returnFlightProvider);
    }



}
