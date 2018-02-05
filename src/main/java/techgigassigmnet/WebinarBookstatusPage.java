package techgigassigmnet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WebinarBookstatusPage {
	static WebDriver driver;
	public WebinarBookstatusPage(WebDriver ldriver)
	{
	this.driver=ldriver;
	}
	
	
	
	@FindBy(how=How.XPATH,using="//i[@class='fa fa-check green']")
	WebElement registersuccess;
	public String WebinarBooksuccess()
	{
		return registersuccess.getAttribute("innerHTML");
	
	}

}
