package base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.safari.SafariDriver;

public class Base {

	public WebDriver driver;

	public WebDriver initializeDriver() throws IOException {

		String browserName = ConfigReader.getProperty("browser");
		System.out.println(browserName);
		ChromeOptions options = new ChromeOptions();;
		options.addArguments("--disable-notifications");

		if (browserName.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);

		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			// firefox code

		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else if (browserName.equals("safari")) {
			WebDriverManager.safaridriver().setup();

			driver = new SafariDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;

	}

}
