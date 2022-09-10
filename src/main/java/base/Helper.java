package base;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;

public class Helper {

    WebDriver driver;
    WebDriverWait wait;
    static ConfigReader configReader;

    public Helper(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
    }

    public static void scroller(WebDriver driver){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,200)");
    }
    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());
    public static String conReader(String properties){
        return configReader.getProperty(properties);
    }
    // getting properties
    public String url(){
        return conReader("url");
    }
    public String origin(){
        return conReader("origin");
    }
    public String destination(){
        return conReader("destination");
    }
    public int departureDay(){
       return Integer.parseInt(conReader("departureDay"));
    }
    public int returnDay(){
       return Integer.parseInt(conReader("returnDay"));
    }
    public boolean isDirect(){
        return Boolean.parseBoolean(conReader("isDirect"));
   }
    public String assertionReader(String properties){
        return  configReader.getPropertyAssertion(properties);
    }
    // getting the assertion properties
    public String assertionUrl(){
        return assertionReader("assertionUrl");
    }
    public String assertionHeader(){
        return assertionReader("assertionHeader");
    }
    public void inPutter(WebElement element, String keys){
        element.sendKeys(keys);
    }
    public WebElement waitElement(By elementName)
    {
        wait.until(ExpectedConditions.elementToBeClickable(elementName));
        return driver.findElement(elementName);
    }


}
