package techgigassigmnet;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	
	static WebDriver driver;
	Actions action;
	 
	public HomePage(WebDriver ldriver)
	{
	this.driver=ldriver;
	}
	@FindBy(how=How.XPATH,using="//a[text()='Login']") 
	@CacheLookup
	WebElement Login;

	@FindBy(how=How.XPATH,using="//*[@id='main-navigation']//span[text()='Jobs']")
	WebElement Jobs;
	
	@FindBy(how=How.XPATH,using="//*[@id='main-navigation']//span[text()='Webinars']")
	WebElement webinars1;
	
	@FindBy(how=How.XPATH,using="//*[@id='main-navigation']/ul/li[4]/ul/li/a")
	List<WebElement> jobdropdown;
	
	public LoginPage clkLogin()
	{
		Login.click();
		return PageFactory.initElements(driver, LoginPage.class);
		
	}
	
	public JobPage clkJobs()
	{
		Jobs.click();
		return PageFactory.initElements(driver, JobPage.class);
		
	}
	
	
	public WebinarPage clkWebinar()
	{
		webinars1.click();
		return PageFactory.initElements(driver, WebinarPage.class);
		
	}
	
	public JobPage searchJob(String jobtype)
	{
		action=new Actions(driver);
		action.moveToElement(Jobs).build().perform();
		
		for (WebElement ele : jobdropdown)
		{ System.out.println("drop " + ele.getAttribute("innerHTML"));
	      if (ele.getAttribute("innerHTML").contains(jobtype)) 
	      {
          ele.click();
          break;
	      }
         }
		return PageFactory.initElements(driver, JobPage.class);
	}
	
	

}
