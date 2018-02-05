package testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import techgigassigmnet.BrowserFactory;
import techgigassigmnet.HomePage;
import techgigassigmnet.WebinarBookPage;
import techgigassigmnet.WebinarBookstatusPage;
import techgigassigmnet.WebinarPage;

public class WebinarTest extends LoginTest {
	
	
	HomePage homePage;
	WebinarPage webinarPage;
	WebinarBookPage webinarBookPage;
	WebinarBookstatusPage webinarBookstatusPage;
	
	
@Test (dependsOnMethods = { "ValidLogin" })	
public void verifyWebinar()
{
	homePage=PageFactory.initElements(BrowserFactory.driver, HomePage.class);
	webinarPage=homePage.clkWebinar();
	int count=webinarPage.verifyRegisternow();
	Assert.assertTrue(count>0);
}

@Test (dependsOnMethods = { "verifyWebinar" })	
public void verifyregisterWebinar()
{
	 webinarBookPage=webinarPage.WebinarRegister();
	 webinarBookstatusPage=webinarBookPage.WebinarBook();
	 
	String status= webinarBookstatusPage.WebinarBooksuccess();
	System.out.println("status of webinar>> "+status);
	Assert.assertTrue(status.contains("Successfully"));
	
}

}
