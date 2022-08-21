package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

	public WebDriver driver;
	HomePage homePage;

	By flightSearch = By.id("FlightSearchFormWrapper");
	By welcome_header = By.xpath("//div/h1[@class='flight-landing-h1']");
	By originInput = By.id("OriginInput");
	By destinationInput = By.id("DestinationInput");
	By departureDate = By.id("DepartureDate");
	By originDateCalendar = By.id("DepartureDate");
	By originCitySelect = By.xpath("//div[@class='suggestion_item']");
	By destinationCitySelect = By.xpath("//div[@class='suggestion_item']");
	By originCalenderDays = By.xpath("//div/table/tbody/tr/td[@aria-disabled='false']");
	By oneWayCheckbox = By.id("oneWayCheckbox");
	By destinationDateCalendar = By.xpath("//div[@class='D_FSF__col returnDate__col D_FSF__focused_input'] /div[@class='FSF__input_overlay'])");
	By returnDayField = By.id("ReturnDate");
	By transitFilter = By.xpath("//div/label/input[@id='transitFilter']");
	By findTicket = By.xpath("//div/button[@data-testid='formSubmitButton']");
	By forwardDateButton = By.xpath("//div[contains(@aria-label,'forward')]");


	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement welcomeHeader() {
		return driver.findElement(welcome_header);
	}

	public WebElement originInput() {
		return driver.findElement(originInput);
	}

	public WebElement destinationInput() {
		return driver.findElement(destinationInput);
	}

	public WebElement departureDate() {
		return driver.findElement(departureDate);
	}

	public WebElement originDateCalendar() {
		return driver.findElement(originDateCalendar);
	}

	public WebElement originCitySelect() {
		return driver.findElement(originCitySelect);
	}

	public WebElement destinationCitySelect() {
		return driver.findElement(destinationCitySelect);
	}

	public WebElement destinationDateCalendar() {
		return driver.findElement(destinationDateCalendar);
	}
	public WebElement returnDayField() {
		return driver.findElement(returnDayField);
	}

	public WebElement oneWayCheckbox() {
		return driver.findElement(oneWayCheckbox);
	}

	public WebElement transitFilter() {
		return driver.findElement(transitFilter);
	}
	public WebElement findTicket() {
		return driver.findElement(findTicket);
	}
	public WebElement forwardDateButton() {
		return driver.findElement(forwardDateButton);
	}


	public WebElement daySelecter(int number) {
		return this.driver.findElements(originCalenderDays).get(number);
	}
	public List<WebElement> originDays(){
		return (List<WebElement>) this.driver.findElements(originCalenderDays);
	}


	public boolean transitFilterCheck(boolean filter) {
		if (filter) {this.driver.findElement(transitFilter).click();
		} else {

		}
		return filter;
	}
	/*
	public void dayPicker(int number1){
		List<WebElement> origin = (List<WebElement>) originDays();
		if(number1 >origin.size()) {

			forwardDateButton().click();
			forwardDateButton().click();

			List<WebElement> origin2 = (List<WebElement>) originDays();
			number1 = origin.size() - number1;
			for (int i = 0; i < number1 + 1; i++) {
				if (i == number1) {
					origin2.get(i).click();
				} else {
					i++;
				}
			}
		}
		else{
			List<WebElement> origin3 = (List<WebElement>) originDays();
			for (int i = 0; i <number1+1; i++) {
				if (i==number1){
					origin3.get(i).click();
				}
				else{
					i++;
				}
			}
		}
	}*/

	public static void scroller(WebDriver driver){
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)");
	}






}

