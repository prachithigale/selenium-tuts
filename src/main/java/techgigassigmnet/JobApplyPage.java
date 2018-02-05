package techgigassigmnet;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class JobApplyPage {
	

	static WebDriver driver;

	public JobApplyPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	
	@FindBy(how=How.XPATH,using="//*[text()='View Detail']")
	List<WebElement> viewjobdeatils;
	
	@FindBy(how=How.XPATH,using="//*[text()='APPLY on TechGig']")
	WebElement jobapply;
	
	
	
	
	public JobapplyStatusPage Apply(String jobname)
	{
		
		for (WebElement ele2 : viewjobdeatils)
		{ 
			System.out.println("innerHTML " + ele2.getAttribute("innerHTML"));
			System.out.println("getetx " + ele2.getText());
			System.out.println("href " + ele2.getAttribute("href"));
			  if (ele2.getAttribute("href").contains(jobname)) 
			  {
				  ele2.click();
		          break; 
			  }
		}
		jobapply.click();
		return PageFactory.initElements(driver, JobapplyStatusPage.class);
	
	}
	
	

}
