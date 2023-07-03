package framework.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.AbstractComponent.AbstractComponent;

public class Landingpage extends AbstractComponent {
	WebDriver driver;
	String Email=randomEmail();
	
	public Landingpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Create an Account']")
	WebElement create_account;
	
	@FindBy(id="firstname")
	WebElement username;
	
	@FindBy(id="lastname")
	WebElement userlastname;
	
	@FindBy(id="email_address")
	WebElement emailid;
	
	@FindBy(id="password")
	WebElement userpassword;
	
	@FindBy(id="password-confirmation")
	WebElement usercnfpassword;
	
	@FindBy(css=".submit")
	WebElement Submit;
	
	@FindBy(id="email_address-error")
	WebElement emailError;
	
	@FindBy(css="div[class='page messages']")
	WebElement AccountSuccess;
	
	public void create_Account(String name,String lastname,String email,String password,String cnfpassword)
	{
		
		create_account.click();
		username.sendKeys(name);
		userlastname.sendKeys(lastname);
		emailid.sendKeys(email);
		userpassword.sendKeys(password);
		usercnfpassword.sendKeys(cnfpassword);
		Submit.click();
	}
	
	public void gotoURL()
	{
		driver.get("https://magento.softwaretestingboard.com/");
	}
	
	public String errormsg()
	{
		WaitForWebElementToAppear(emailError);
		return emailError.getText();
	}
	
	public String Successmsg() throws InterruptedException
	{
		Thread.sleep(4000);
		WaitForWebElementToAppear(AccountSuccess);
		return AccountSuccess.getText();
	}
	
}
