package src.test.Academy;

import java.io.IOException;

import base.Base;
import base.ConfigReader;
import org.openqa.selenium.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.FlightsPage;
import pageObjects.HomePage;
import pageObjects.PaymentPage;

@SuppressWarnings("unused")
public class HomePageTest extends Base {
	public WebDriver driver;
	HomePage homePage;
	FlightsPage flightsPage;
	PaymentPage paymentPage;

	private static Logger logger = LoggerFactory.getLogger(HomePageTest.class);


	String url = ConfigReader.getProperty("url");
	String origin = ConfigReader.getProperty("origin");
	String destination = ConfigReader.getProperty("destination");
	int departureDay = Integer.parseInt(ConfigReader.getProperty("departureDay"));
	int returnDay = Integer.parseInt(ConfigReader.getProperty("returnDay"));
	boolean isDirect = Boolean.parseBoolean(ConfigReader.getProperty("isDirect"));

	String assertionUrl = ConfigReader.getPropertyAssertion("assertionUrl");
	String assertionHeader = ConfigReader.getPropertyAssertion("assertionHeader");

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(url);
		Assert.assertEquals(driver.getCurrentUrl(),url);
	}



	@Test
	public void HomePageVerification() throws InterruptedException {

		HomePage hp = new HomePage(driver);
		FlightsPage fp = new FlightsPage(driver);
		PaymentPage pp = new PaymentPage(driver);

		try {
			Assert.assertEquals(hp.welcomeHeader().getText(),assertionHeader);
			Assert.assertEquals(hp.driver.getCurrentUrl(),assertionUrl);
			logger.info("Driver Checked, Driver url is corect");
		}
		catch(AssertionError e) {
			System.out.println("Website Could not opened properly "+e);
			logger.error("Driver checked, Driver url is not correct");
		}
		try {
			Assert.assertTrue(hp.originInput().isDisplayed());
			Assert.assertTrue(hp.originInput().isEnabled());
			hp.originInput().click();
			hp.originInput().sendKeys(origin);
			logger.info("Origin input clicked");
		}
		catch(ElementClickInterceptedException | AssertionError e) {
			System.out.println("Click is intercepted "+e);
			logger.error("Origin input could not clicked");
		}
		try {
			Assert.assertTrue(hp.originCitySelect().isDisplayed());
			Assert.assertTrue(hp.originCitySelect().isEnabled());
			hp.originCitySelect().click();
			hp.destinationInput().sendKeys(destination);
			logger.info("Origin city added");
		}
		catch(ElementClickInterceptedException | NoSuchElementException e) {
			System.out.println("Click is intercepted or element couldn't found "+e);
			logger.error("Origin city could not added");
		}
		try {
			Assert.assertTrue(hp.destinationCitySelect().isDisplayed());
			Assert.assertTrue(hp.destinationCitySelect().isEnabled());
			hp.destinationCitySelect().click();
			logger.info("Destination city added");
		}
		catch(ElementClickInterceptedException | NoSuchElementException e) {
			System.out.println("Click is intercepted or element couldn't found "+e);
			logger.error("Destination city could not added");
		}
		try {
			Assert.assertTrue(hp.originDateCalendar().isDisplayed());
			Assert.assertTrue(hp.originDateCalendar().isEnabled());
			hp.originDateCalendar().click();
			logger.info("Origin Date calendar opened");
		}
		catch(ElementClickInterceptedException | NoSuchElementException e) {
			System.out.println("Click is intercepted or element couldn't found "+e);
			logger.error("Origin Date calendar could ot opened");
		}
		try {

			hp.scroller(driver);
			Assert.assertTrue(hp.daySelecter(departureDay).isDisplayed());
			Assert.assertTrue(hp.daySelecter(departureDay).isDisplayed());
			hp.daySelecter(departureDay).click();
			logger.info("Departure day selected");
		}
		catch(IndexOutOfBoundsException | NoSuchElementException e) {
			System.out.println("Your value out of index or Element couldnt find "+e);
			logger.error("Departure day could not selected");
		}
		try {
			Assert.assertTrue(hp.oneWayCheckbox().isDisplayed());
			Assert.assertTrue(hp.oneWayCheckbox().isEnabled());
			hp.oneWayCheckbox().click();
			logger.info("One way check box checked");

		}
		catch(ElementClickInterceptedException | NoSuchElementException e) {
			System.out.println("Click is intercepted or element couldn't found "+e);
			logger.error("One way check box could not checked");
		}
		String startDate = hp.departureDate().getAttribute("value");
		System.out.println(startDate);

		try {
			Assert.assertTrue(hp.daySelecter(returnDay).isDisplayed());
			Assert.assertTrue(hp.daySelecter(returnDay).isEnabled());
			hp.daySelecter(returnDay).click();
			logger.info("Return day selected");

		}
		catch(IndexOutOfBoundsException | NoSuchElementException e) {
			System.out.println("Your value out of index or Element couldnt find "+e);
			logger.error("Return day could not selected");
		}

		String returnDate = hp.returnDayField().getAttribute("value");
		System.out.println(returnDate);

		try {
			Assert.assertTrue(isDirect);
			hp.transitFilterCheck(isDirect);
			logger.info("Is direct check box selected");
		}
		catch(NullPointerException e) {
			System.out.println("Could not get the values from data.properties file "+e);
			logger.error("Is direct check box could not selected");
		}
		try {
			Assert.assertTrue(hp.findTicket().isDisplayed());
			Assert.assertTrue(hp.findTicket().isEnabled());
			hp.findTicket().click();
			logger.info("Find Ticket clicked");
		}
		catch(ElementClickInterceptedException | NoSuchElementException e) {
			System.out.println("Click is intercepted or element couldn't found "+e);
			logger.error("Find ticker could not selected");
		}
		try {
			Assert.assertTrue(fp.originFlightPicker().isDisplayed());
			Assert.assertTrue(fp.originFlightPicker().isEnabled());
			fp.originFlightPicker().click();
			logger.info("Origin flight clicked");
		}
		catch(ElementClickInterceptedException | NoSuchElementException e) {
			System.out.println("Click is intercepted or element couldn't found "+e);
			logger.error("Origin flight could not selected");
		}
		String startFlightProviderName = fp.startFlightProvider().getText();

		try {
			Assert.assertTrue(fp.returnFlightPicker().isDisplayed());
			Assert.assertTrue(fp.returnFlightPicker().isEnabled());
			fp.returnFlightPicker().click();
			logger.info("Return flight clicked");
		}
		catch(ElementClickInterceptedException | NoSuchElementException e) {
			System.out.println("Click is intercepted or element couldn't found "+e);
			logger.error("Return flight couldnt clicked");
		}
		String returnFlightProviderName = fp.returnFlightProvider().getAttribute("alt");

		try {
			Assert.assertTrue(fp.packagePicker().isDisplayed());
			Assert.assertTrue(fp.packagePicker().isEnabled());
			fp.packagePicker().click();
			logger.info("Package picker clicked");
		}
		catch(ElementClickInterceptedException | NoSuchElementException e) {
			System.out.println("Click is intercepted or element couldn't found "+e);
			logger.error("Package picker could not clicked");
		}
		try {
			Assert.assertEquals(origin+" "+destination,pp.reservationTitle().getText());
			Assert.assertEquals(startDate.split(",")[0],pp.startDate().getText().split(",")[0]); // check dates
			Assert.assertEquals(returnDate.split(",")[0],pp.returnDate().getText().split(",")[0]); // check dates
			Assert.assertEquals(startFlightProviderName,pp.flightProviderName().getText()); // check airline
			Assert.assertEquals(returnFlightProviderName,
					pp.returnFlightProviderName().getText()); // check airline
			logger.info("Last assertions passed");
		}
		catch(AssertionError e) {
			System.out.println("Your values dont match "+e);
			logger.error("Last assertions could not passed");
		}
	}

	@AfterTest(enabled = false)
	public void destroyIt() {
		driver.quit();
	}

	}

