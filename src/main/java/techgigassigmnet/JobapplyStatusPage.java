package techgigassigmnet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class JobapplyStatusPage {

	static WebDriver driver;

	public JobapplyStatusPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	@FindBy(how=How.XPATH,using="//i[@class='fa fa-check green']")
	WebElement applystatus;
	public String jobapplysuccess()
	{
		return applystatus.getAttribute("innerHTML");
	
	}
}
