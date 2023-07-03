package framework.pageobject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import framework.AbstractComponent.AbstractComponent;

public class AddItemPage extends AbstractComponent {
	WebDriver driver;
	
	public AddItemPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@id='ui-id-3']")
	 WebElement newsection;
	
	@FindBy(linkText="Phoebe Zipper Sweatshirt")
     WebElement newproduct;
	
	@FindBy(xpath="//div[@option-label='XS']")
	 WebElement productSize;
	
	@FindBy(xpath="//div[@option-label='White']")
	 WebElement productColour;
	
	@FindBy(id="product-addtocart-button")
	 WebElement addToCart;
	
	@FindBy(xpath="(//a[@class='level-top ui-corner-all']) [4]")
	 WebElement gears;
	
	@FindBy(linkText="Watches")
	WebElement watch;
	
	@FindBy(xpath="(//div[@class='filter-options-title']) [2]")
	 WebElement clickOnPrice;
	
	@FindBy(css="a[href*='price=40-50']")
	 WebElement SelectPriceRange;
	
	@FindBy(xpath="(//div[@data-role='title']) [3]")
	 WebElement clickOnMaterial;
	
	@FindBy(css="a[href*='material=45']")
	 WebElement SelectRubber;
	
	@FindBy(linkText="Endurance Watch")
	 WebElement clickOnwatch;
	 
	@FindBy(id="product-addtocart-button")
	 WebElement AddwatchtoCart;
	
	@FindBy(xpath="(//a[@class='level-top ui-corner-all']) [3]")
	 WebElement menSection;
	
	@FindBy(css="#ui-id-18")
	 WebElement bottom;
	
	@FindBy(css="#ui-id-23")
	 WebElement pant;
	
	@FindBy(xpath="(//select[@id='sorter']) [1]")
	 WebElement sortOption;
	
	@FindBy(css=".product-item-info")
	 WebElement clickonPant;
	
	@FindBy(xpath="(//div[@class=\"swatch-option text\"]) [3]")
	 WebElement pantsize;
	
	@FindBy(xpath="//div[@option-label='Green']")
	 WebElement pantcolour;
	
	@FindBy(css=".action.primary.tocart")
	 WebElement addPantToCart;
	

	
	public void addWhatsNew() throws InterruptedException
	{
		sleep(1000);
		newsection.click();
		Actions a= new Actions(driver);
		a.scrollByAmount(0, 1500).build().perform();
		a.moveToElement(newproduct).click().build().perform();
		sleep(2000);
		a.scrollByAmount(0, 500).build().perform();
		productSize.click();
		productColour.click();
		addToCart.click();

	}
	
	public void addWatch() 
	{
		Actions a= new Actions(driver);
		a.moveToElement(gears).build().perform();
		a.moveToElement(watch).keyDown(Keys.CONTROL).click().build().perform();
	    Set<String> windows=driver.getWindowHandles();
	    Iterator<String> it=windows.iterator();
	    String parentid=it.next();
	    String childid=it.next();
		driver.switchTo().window(childid);
		clickOnPrice.click();
		SelectPriceRange.sendKeys(Keys.CONTROL,Keys.ENTER);
		clickOnMaterial.click();
		SelectRubber.click();
		a.scrollByAmount(0, 500).build().perform();
		clickOnwatch.click();
		AddwatchtoCart.click();
		driver.close();
		driver.switchTo().window(parentid).navigate().refresh();
		
	}
	
	public void addPants() throws InterruptedException
	{
		Actions a= new Actions(driver);
		a.moveToElement(menSection).build().perform();
		a.moveToElement(bottom).build().perform();
		a.moveToElement(pant).click().build().perform();
		WebElement sort=sortOption;
		Select dropdown = new Select(sort);
	    dropdown.selectByVisibleText("Price");
	    sleep(2000);
	    clickonPant.click();
	    a.scrollByAmount(0, 500).build().perform();
	    pantsize.click();
	    pantcolour.click();
	    addPantToCart.click();
	    sleep(2000);	
	}
	
	
	
	
	
}
