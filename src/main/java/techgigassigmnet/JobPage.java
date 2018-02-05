package techgigassigmnet;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class JobPage {
	
	static WebDriver driver;

	public JobPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	

	@FindBy(how=How.XPATH,using="//*[@id='input_txt']")
	WebElement Jobkeyword;


	@FindBy(how=How.XPATH,using="//*[@id='cboWorkExp1']")
	WebElement Jobexperience;
	
	@FindBy(how=How.XPATH,using="//*[@id='btn-srch-search']")
	WebElement Jobsearch;
	
	

	
	
	
	
	public JobApplyPage searchsearch(String keyword)
	{
		
		Jobkeyword.sendKeys(keyword);
		//Jobexperience.sendKeys(exp);
		Jobsearch.click();
		
		return PageFactory.initElements(driver, JobApplyPage.class);
		
}
	
	
	
	
}


