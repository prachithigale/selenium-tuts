/**
 * 
 */
package techgigassigmnet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author prachi
 *
 */
public class LoginPage {

	static WebDriver driver;
	 
	 
	public LoginPage(WebDriver ldriver)
	{
	this.driver=ldriver;
	}
	


	@FindBy(id="username") 
	@CacheLookup
	WebElement Email;
	

	@FindBy(id="password") 
	@CacheLookup
	WebElement password;
	
	@FindBy(id="button_login") 
	@CacheLookup
	WebElement LoginButton;
	

	
	@FindBy(how=How.XPATH,using="//*[@id='user-status']//a[contains(@href,'myprofile')]/h4")
	@CacheLookup
	WebElement user;
	
	public HomePage login(String Emailid,String pass)
	{

	
	Email.sendKeys(Emailid);
	password.sendKeys(pass);
	LoginButton.click();
	return PageFactory.initElements(driver, HomePage.class);
	}
	
	public String getUsername()
	{
		
		return user.getAttribute("innerHTML");
		
	}
}
