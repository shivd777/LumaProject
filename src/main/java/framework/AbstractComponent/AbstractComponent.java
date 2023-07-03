package framework.AbstractComponent;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {

	WebDriver driver;

	public AbstractComponent(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(linkText="Sign In")
	WebElement signUp_account;
	
	@FindBy(id="email")
	WebElement usermail;
	
	@FindBy(id="pass")
	WebElement userpassword;
	
	@FindBy(css=".action.login.primary")
	WebElement signUpsubmit;
	
	public void WaitForWebElementToAppear(WebElement findBy)
	{
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void SignUp_Account(String email,String password)
	{
		signUp_account.click();
		usermail.sendKeys(email);
		userpassword.sendKeys(password);
		signUpsubmit.click();
	}
	
	public void sleep(int num) throws InterruptedException
	{
		Thread.sleep(num);
	}
	
	public static String randomEmail()
	{
		String number=RandomStringUtils.randomNumeric(4);
		
		String Email ="s.deshmukh"+number+"@gmail.com";
		
		return Email;
	}
	

	
}
