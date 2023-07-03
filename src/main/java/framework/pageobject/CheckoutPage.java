package framework.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import framework.AbstractComponent.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	
	WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[1]/div[1]/fieldset[1]/div[1]/div[1]/div[1]/input[1]")
	 WebElement address;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[1]/div[1]/div[4]/div[1]/input[1]")
	 WebElement cityName;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[1]/div[1]/div[5]/div[1]/select[1]")
	 WebElement regionName;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[1]/div[1]/div[7]/div[1]/input[1]")
	 WebElement pincode;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[1]/div[1]/div[8]/div[1]/select[1]")
	 WebElement countryName;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[1]/div[1]/div[9]/div[1]/input[1]")
	 WebElement mobileNo;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[2]/div[1]/div[3]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")
	 WebElement radiobutton;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[2]/div[1]/div[3]/form[1]/div[3]/div[1]/button[1]/span[1]")
	 WebElement Next;
	
	@FindBy(xpath="//div[@class='shipping-address-item selected-item']")
	 WebElement AddressBox;
	
	public void checkoutDetails(String place,String city,String region,String pin,String country,String mobile) throws InterruptedException
	{
		address.sendKeys(place);
		cityName.sendKeys(city);
	     Select menu=new Select(regionName);
	     menu.selectByVisibleText(region);
	     Thread.sleep(1000);
	     pincode.sendKeys(pin);
	     Select menu2= new Select(countryName);
	     menu2.selectByVisibleText(country);
	     mobileNo.sendKeys(mobile);
	     Radiobut();
	     sleep(5000);
	}
	
	public WebElement savedAddress()
	{
		return AddressBox;
	}
	
	public void Radiobut()
	{
	     radiobutton.click();

	}
	
	public void nextBut() throws InterruptedException
	{
	     Next.click();
	     sleep(5000);

	}
	
	
	
	
	

}
