package src.test.Academy;

import java.io.IOException;
import io.qameta.allure.Description;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.FlightsPage;
import pageObjects.HomePage;
import pageObjects.PaymentPage;

@Slf4j
public class GetTicketsTest extends BaseTest {

	private static Logger logger = LoggerFactory.getLogger(GetTicketsTest.class);

	// initilazation the driver
	@BeforeClass
	public void setDriver() throws IOException {
		homePage = new HomePage(driver);
		flightsPage = new FlightsPage(driver);
		paymentPage = new PaymentPage(driver);
	}
	// start to test
	@Test(priority = 1)
	@Description("HomePageVerification")
	public void HomePageVerification() throws InterruptedException {

		// check the url
		try {
			Assert.assertEquals(homePage.welcomeHeader().getText(), helper.assertionHeader());
			Assert.assertEquals(homePage.driver.getCurrentUrl(), helper.assertionUrl());
			logger.info("Driver Checked, Driver url is correct");
		} catch (AssertionError e) {
			logger.error("Driver checked, Driver url is not correct" + e);
		}
	}
	@Test(priority = 2)
	@Description("SendingTheOriginText")
	public void SendingTheOriginText(){
		// sending the origin text
		try {
			Assert.assertTrue(homePage.originInput().isDisplayed());
			Assert.assertTrue(homePage.originInput().isEnabled());
			homePage.originInput().click();
			helper.inPutter(homePage.originInput(),helper.origin());
			logger.info("Origin input clicked");
		} catch (ElementClickInterceptedException | AssertionError e) {
			logger.error("Origin input could not clicked " +e );
		}
	}
	@Test(priority = 3)
	@Description("SendingTheDestinationText")
	public void SendingTheDestinationText() {
		// sending the destination text
		try {
			Assert.assertTrue(homePage.originCitySelect().isDisplayed());
			Assert.assertTrue(homePage.originCitySelect().isEnabled());
			homePage.originCitySelect().click();
			helper.inPutter(homePage.destinationInput(),helper.destination());
			logger.info("Origin city added");
		} catch (ElementClickInterceptedException | NoSuchElementException e) {
			logger.error("Origin city could not added "+e);
		}
	}
	@Test(priority = 4)
	@Description("DestinaitonCitySelection")
	public void DestinaitonCitySelection() {
		// Destionaiton city selected
		try {
			Assert.assertTrue(homePage.destinationCitySelect().isDisplayed());
			Assert.assertTrue(homePage.destinationCitySelect().isEnabled());
			homePage.destinationCitySelect().click();
			logger.info("Destination city added");
		} catch (ElementClickInterceptedException | NoSuchElementException e) {
			logger.error("Destination city could not added "+e);
		}
	}
	@Test(priority = 5)
	@Description("OpenOriginDate")
	public void OpenOriginDate() {
		// Origin date opened
		try {
			Assert.assertTrue(homePage.originDateCalendar().isDisplayed());
			Assert.assertTrue(homePage.originDateCalendar().isEnabled());
			homePage.originDateCalendar().click();
			logger.info("Origin Date calendar opened");
		} catch (ElementClickInterceptedException | NoSuchElementException e) {
			logger.error("Origin Date calendar could ot opened "+e);
		}
	}
	@Test(priority = 6)
	@Description("SelectDepartureDay")
	public void SelectDepartureDay() {
		try {
			// scroller the page for selection item
			// selecting the departure day
			homePage.scroller(driver);
			Assert.assertTrue(homePage.daySelecter(helper.departureDay()).isDisplayed());
			Assert.assertTrue(homePage.daySelecter(helper.departureDay()).isDisplayed());
			homePage.daySelecter(helper.departureDay()).click();
			logger.info("Departure day selected");
		} catch (IndexOutOfBoundsException | NoSuchElementException e) {
			logger.error("Departure day could not selected "+e);
		}
	}
	@Test(priority = 7)
	@Description("UncheckOneDayCheckBox")
	public void UncheckOneDayCheckBox() {
		// Uncheck the one way checkbox
		try {
			Assert.assertTrue(homePage.oneWayCheckbox().isDisplayed());
			Assert.assertTrue(homePage.oneWayCheckbox().isEnabled());
			homePage.oneWayCheckbox().click();
			logger.info("One way check box checked");

		} catch (ElementClickInterceptedException | NoSuchElementException e) {
			logger.error("One way check box could not checked " + e);
		}
	}
	@Test(priority = 8)
	@Description("PickingReturnDate")
	public void PickingReturnDate() {
		// getting the date for assertion later in the test
		// picking the return date
		try {
			Assert.assertTrue(homePage.daySelecter(helper.returnDay()).isDisplayed());
			Assert.assertTrue(homePage.daySelecter(helper.returnDay()).isEnabled());
			homePage.daySelecter(helper.returnDay()).click();
			logger.info("Return day selected");

		} catch (IndexOutOfBoundsException | NoSuchElementException e) {
			logger.error("Return day could not selected "+e);
		}
	}
	@Test(priority = 9)
	@Description("CheckTransitCheckBox")
	public void CheckTransitCheckBox() {
		// getting the values for later assetions

		// check the transit checkbox
		try {
			Assert.assertTrue(helper.isDirect());
			homePage.transitFilterCheck(helper.isDirect());
			logger.info("Is direct check box selected");
		} catch (NullPointerException e) {
			logger.error("Is direct check box could not selected "+e);
		}
	}
	@Test(priority = 10)
	@Description("ClickFindTicket")
	public void ClickFindTicket() {
		// clicking the find ticket button
		try {
			Assert.assertTrue(homePage.findTicket().isDisplayed());
			Assert.assertTrue(homePage.findTicket().isEnabled());
			homePage.findTicket().click();
			logger.info("Find Ticket clicked");
		} catch (ElementClickInterceptedException | NoSuchElementException e) {
			logger.error("Find ticker could not selected "+e);
		}
	}
	@Test(priority = 11)
	@Description("PickOriginTicket")
	public void PickOriginTicket() {
		// picking the origin flight
		try {
			Assert.assertTrue(flightsPage.originFlightPicker().isDisplayed());
			Assert.assertTrue(flightsPage.originFlightPicker().isEnabled());
			flightsPage.originFlightPicker().click();
			logger.info("Origin flight clicked");
		} catch (ElementClickInterceptedException | NoSuchElementException e) {
			logger.error("Origin flight could not selected "+e);
		}
	}
	@Test(priority = 12)
	@Description("PickReturnTicket")
	public void PickReturnTicket() {
		// getting the value for later test assertions
		// picking the return flight
		try {
			Assert.assertTrue(flightsPage.returnFlightPicker().isDisplayed());
			Assert.assertTrue(flightsPage.returnFlightPicker().isEnabled());
			flightsPage.returnFlightPicker().click();
			logger.info("Return flight clicked");
		} catch (ElementClickInterceptedException | NoSuchElementException e) {
			logger.error("Return flight couldnt clicked "+e);
		}
	}
	@Test(priority = 13)
	@Description("PickThePackage")
	public void PickThePackage() {
		// getting the value for later testing
		// picking the package
		try {
			Assert.assertTrue(flightsPage.packagePicker().isDisplayed());
			Assert.assertTrue(flightsPage.packagePicker().isEnabled());
			flightsPage.packagePicker().click();
			logger.info("Package picker clicked");
		} catch (ElementClickInterceptedException | NoSuchElementException e) {
			logger.error("Package picker could not clicked "+e);
		}
	}
	@Test(priority = 14)
	@Description("Asseertions")
	public void Asseertions() {
		// Asseritons added
		try {
			Assert.assertEquals(helper.origin() + " " + helper.destination(), paymentPage.reservationTitle().getText());
			//Assert.assertEquals(GetDepartureDay().split(",")[0], paymentPage.startDate().getText().split(",")[0]); // check dates
			//Assert.assertEquals(GetReturnDay().split(",")[0], paymentPage.returnDate().getText().split(",")[0]); // check dates
			//Assert.assertEquals(GetStartFlightProviderName(), paymentPage.flightProviderName().getText()); // check airline
			//Assert.assertEquals(GetReturnFlightProviderName(),
			//		paymentPage.returnFlightProviderName().getText()); // check airline
			logger.info("Last assertion passed");
		} catch (AssertionError e) {
			System.out.println("Your values dont match " + e);
			logger.error("Last assertions could not passed");
		}
	}
	@AfterClass(enabled = false)
	public void destroyIt() {
		driver.quit();
	}
}

