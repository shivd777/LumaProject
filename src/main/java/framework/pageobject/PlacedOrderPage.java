package framework.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.AbstractComponent.AbstractComponent;

public class PlacedOrderPage extends AbstractComponent {
	
	WebDriver driver;
	
	public PlacedOrderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class=\"base\"]")
	 WebElement ordersuccessmsg;
	
	@FindBy(css=".order-number")
	 WebElement orderNum;

	public String orderplcaed() throws InterruptedException
	{
		String successmsg=ordersuccessmsg.getText();
		sleep(2000);
		return successmsg;
	}
	
	public void OrderNumber()
	{
		String orderid=orderNum.getText();
		System.out.println("OrderNumber:"+ orderid);
		
	}
}
