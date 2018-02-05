package testcase;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import techgigassigmnet.BrowserFactory;
import techgigassigmnet.ExcelFactory;
import techgigassigmnet.HomePage;
import techgigassigmnet.LoginPage;

public class LoginTest extends BaseTest{
	


	
	
	HomePage homePage;
	LoginPage loginPage;
	XSSFSheet xSSFSheet;
	

	@Test(dataProvider = "Authentication")
	public void ValidLogin(String Email, String sPassword,String username)
	{
		//BrowserFactory.driver=BrowserFactory.getBrowser("chrome", System.getProperty("app.url"));
		System.out.println("Login started  "+Email+"     "+sPassword+"  "+username);
		homePage=PageFactory.initElements(BrowserFactory.driver, HomePage.class);
		loginPage=homePage.clkLogin();
		//xSSFSheet=ExcelFactory.readexcel(0);
		//loginPage.login("thigaleprachi5@gmail.com","pkt2018!");
		loginPage.login(Email,sPassword);
		
		String user=loginPage.getUsername();
		System.out.println("User Logged in      "+user);
	  Assert.assertTrue(user.contains(username));
		
	}
	
	
	
	@DataProvider
	 public Object[][] Authentication() throws Exception{
	//	ExcelFactory excelFactory=new ExcelFactory();
		Object[][] testObjArray = ExcelFactory.getTableArray("D:\\selenium_jar\\excel\\login.xlsx",Integer.parseInt("0"));
		 
    	return (testObjArray);
	}

}
