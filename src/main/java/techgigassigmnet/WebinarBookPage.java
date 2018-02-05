package techgigassigmnet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WebinarBookPage {
	static WebDriver driver;
	public WebinarBookPage(WebDriver ldriver)
	{
	this.driver=ldriver;
	}
	
	@FindBy(how=How.XPATH,using="//span[text()='Book Your seat']")
	WebElement Bookseat;
	

	public WebinarBookstatusPage WebinarBook()
	{
		
	
		Bookseat.click();
		return PageFactory.initElements(driver, WebinarBookstatusPage.class);
	
	}
	
	

}
