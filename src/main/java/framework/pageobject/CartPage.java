package framework.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.AbstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;
	List<WebElement> prize;
	String CartTotal;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".action.showcart")
	 WebElement clickonCart;
	
	@FindBy(xpath="//a[@class='action viewcart']")
	 WebElement viewCart;
	
	@FindBy(css="input[data-cart-item-id*='MP06-34-Green'][title='Qty']")
	WebElement editBox;
	
	@FindBy(xpath="//button[@title='Update Shopping Cart']")
	 WebElement updateCart;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/main[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[3]/td[1]/strong[1]/span[1]")
	 WebElement orderTotal;
	 
	@FindBy(xpath="(//li[@class='item']) [1]")
	 WebElement proceedCheckout;
	
	
	public void cartItem() throws InterruptedException
	{
		Actions a= new Actions(driver);
		a.scrollByAmount(0,0);
		clickonCart.click();
		viewCart.click();
		a.scrollByAmount(0,500).build().perform();
		editBox.sendKeys(Keys.DELETE,Keys.NUMPAD4);
		updateCart.click();	
		sleep(5000);
		a.scrollByAmount(0, 200);
				
	}
	
	public String cartValue() throws InterruptedException
	{
		sleep(2000);
//		Actions a= new Actions(driver);
//		a.scrollByAmount(0, 200);
		CartTotal = orderTotal.getText();
		System.out.println("InitialPrize :" + CartTotal);
		return CartTotal;
	}
	
	public void proceedTocheckout()
	{
		proceedCheckout.click();
	}
	

}
