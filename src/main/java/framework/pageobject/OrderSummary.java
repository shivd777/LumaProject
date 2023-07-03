package framework.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.AbstractComponent.AbstractComponent;

public class OrderSummary extends AbstractComponent {
	WebDriver driver;
	
	public OrderSummary(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[2]/aside[1]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[1]/strong[1]/span[1]")
	 WebElement Amount;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[3]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[4]/div[1]/button[1]/span[1]")
	 WebElement clickOnOrder;
	
	public String validate() throws InterruptedException
	{
		sleep(2000);
		String finalAmount= Amount.getText();
		System.out.println("Final Prize:" + finalAmount);
		return finalAmount;
	}
	
	public void ClickOnplacedOrder() throws InterruptedException
	{
		clickOnOrder.click();
		sleep(5000);

	}
	
	

}
