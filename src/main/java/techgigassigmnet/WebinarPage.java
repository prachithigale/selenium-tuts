package techgigassigmnet;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WebinarPage {
	static WebDriver driver;
	public WebinarPage(WebDriver ldriver)
	{
	this.driver=ldriver;
	}

	

	@FindBy(how=How.XPATH,using="//span[text()='Register Now']")
	List<WebElement> Registernow;


   
	 public int verifyRegisternow()
	 {
		 return Registernow.size();
	 }
	
	public WebinarBookPage WebinarRegister()
	{
		
		for (WebElement ele2 : Registernow)
		{ 
			
			ele2.click();
			break;
		}
	
		return PageFactory.initElements(driver, WebinarBookPage.class);
	}
}
