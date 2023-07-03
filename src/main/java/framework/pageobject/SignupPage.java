package framework.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.AbstractComponent.AbstractComponent;

public class SignupPage extends AbstractComponent {
	WebDriver driver;
	
	public SignupPage(WebDriver driver)
	{
		super(driver);
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
	
	@FindBy(xpath="(//span[@class='logged-in']) [1]")
	WebElement WelcomeMsg;
	
	@FindBy(css="div[class='panel header'] button[type='button']")
	WebElement profileMenu;
	
	@FindBy(xpath="(//div[@class=\"customer-menu\"] //li[@class=\"authorization-link\"]) [1]")
	WebElement signout;
	
	@FindBy(className="base")
	WebElement logoutmsg;
	
	@FindBy(css=".message-error.error.message ")
	WebElement errormsg;
	
	@FindBy(xpath="(//strong[@class='title']) [1]")
	WebElement Title;
	
	public void SignUp_Account(String email,String password)
	{
		signUp_account.click();
		usermail.sendKeys(email);
		userpassword.sendKeys(password);
		signUpsubmit.click();
	}
	
	public String SuccessMsg() throws InterruptedException
	{
	
		sleep(2000);
		return WelcomeMsg.getText();
	}
	
	public String SignoutMsg()
	{
		
		WaitForWebElementToAppear(logoutmsg);
		return logoutmsg.getText();
	}
	
	public String FailedMsg()
	{
		WaitForWebElementToAppear(errormsg);
		return errormsg.getText();
	}
	public void Signout()
	{
		profileMenu.click();
		signout.click();
	}
	
}
