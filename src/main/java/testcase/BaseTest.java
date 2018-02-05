package testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import techgigassigmnet.BrowserFactory;

public class BaseTest {
	
	
	@BeforeSuite
	 public void setup()
	 {
		BrowserFactory.driver=BrowserFactory.getBrowser("chrome", System.getProperty("app.url")); 
		System.out.println("Browser Launched");
	 }
}
