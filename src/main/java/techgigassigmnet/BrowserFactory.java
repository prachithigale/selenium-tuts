package techgigassigmnet;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	public static WebDriver driver;
	//String URL="https://www.amazon.in";
	public  static WebDriver getBrowser(String browser,String URL)
	{
		
		if(browser.equalsIgnoreCase("chrome")){

	System.setProperty("webdriver.chrome.driver","D:\\selenium_jar\\diver\\chrome_new\\chromedriver.exe");
	 driver=new ChromeDriver();
		
	}else if (browser.equalsIgnoreCase("FF")){
	{
		System.setProperty("webdriver.chrome.driver","D:\\selenium_jar\\diver\\chrome_new\\chromedriver.exe");
		 driver=new InternetExplorerDriver();
		
	}
		
	}
	else if(browser.equalsIgnoreCase("IE")){

			System.setProperty("webdriver.chrome.driver","D:\\selenium_jar\\diver\\chrome_new\\chromedriver.exe");
			 driver=new InternetExplorerDriver();
			
			}	
		
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	

}
