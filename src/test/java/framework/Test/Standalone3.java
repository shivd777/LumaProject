package framework.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import framework.TestComponents.BaseTest;
import framework.pageobject.AddItemPage;
import framework.pageobject.SignupPage;

public class Standalone3 extends BaseTest{
	@Test
	public void purchase() throws InterruptedException
	{
	SignupPage signin=new SignupPage(driver);
	signin.SignUp_Account("s.deshmukh1214@gmail.com", "s@8291949412");	 		//signin
					
//	Thread.sleep(1000);
//	driver.findElement(By.xpath("//a[@id='ui-id-3']")).click();
//	Actions a= new Actions(driver);
//	a.moveToElement(driver.findElement(By.xpath("//a[@title='Phoebe Zipper Sweatshirt']"))).click().build().perform();				//product-selected
//	Thread.sleep(3000);
//	a.scrollByAmount(0, 500).build().perform();
//	driver.findElement(By.xpath("//div[@option-label='XS']")).click();
//	driver.findElement(By.xpath("//div[@option-label='White']")).click();
//	driver.findElement(By.id("product-addtocart-button")).click();
	AddItemPage additem = new AddItemPage(driver);
	additem.addWhatsNew();
	
//	//Thread.sleep(3000);
//	a.moveToElement(driver.findElement(By.xpath("(//a[@class='level-top ui-corner-all']) [4]"))).build().perform();
//    a.moveToElement(driver.findElement(By.linkText("Watches"))).keyDown(Keys.CONTROL).click().build().perform();
//    Set<String> windows=driver.getWindowHandles();
//    Iterator<String> it=windows.iterator();
//    String parentid=it.next();
//    String childid=it.next();
//	driver.switchTo().window(childid);
//	driver.findElement(By.xpath("(//div[@class='filter-options-title']) [2]")).click();
//	Thread.sleep(2000);
//	driver.findElement(By.cssSelector("a[href*='40-50']")).sendKeys(Keys.CONTROL,Keys.ENTER);
//	Thread.sleep(2000);
//	a.scrollByAmount(0, 1000).build().perform();
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("(//div[@data-role='title']) [3]")).click();
//	Thread.sleep(2000);
//	driver.findElement(By.cssSelector("a[href*='material=45']")).click();
//	Thread.sleep(2000);
//	a.scrollByAmount(0, 500).build().perform();
//	driver.findElement(By.linkText("Endurance Watch")).click();
//	Thread.sleep(2000);
//	driver.findElement(By.id("product-addtocart-button")).click();
//	driver.close();
//	driver.switchTo().window(parentid).navigate().refresh();
	
	additem.addWatch();
	
//	Thread.sleep(4000);
//	a.moveToElement(driver.findElement(By.xpath("(//a[@class='level-top ui-corner-all']) [3]"))).build().perform();
//	a.moveToElement(driver.findElement(By.cssSelector("#ui-id-18"))).build().perform();
//	a.moveToElement(driver.findElement(By.cssSelector("#ui-id-23"))).click().build().perform();
//	WebElement sort=driver.findElement(By.xpath("(//select[@id='sorter']) [1]"));
//	 Select dropdown = new Select(sort);
//     dropdown.selectByVisibleText("Price");
//     Thread.sleep(4000);
//     driver.findElement(By.cssSelector(".product-item-info")).click();
//     a.scrollByAmount(0, 500).build().perform();
//     driver.findElement(By.xpath("(//div[@class=\"swatch-option text\"]) [3]")).click();
//     driver.findElement(By.xpath("//div[@option-label='Green']")).click();
//     driver.findElement(By.cssSelector(".action.primary.tocart")).click();
//     Thread.sleep(4000);
//     a.scrollByAmount(0,0);
//     driver.findElement(By.cssSelector(".action.showcart")).click();
//     driver.findElement(By.xpath("//a[@class='action viewcart']")).click();
//     a.scrollByAmount(0,500).build().perform();
//     driver.findElement(By.cssSelector("input[data-cart-item-id*='MP06-34-Green'][title='Qty']")).sendKeys(Keys.DELETE,Keys.NUMPAD4);
//     Thread.sleep(1000);
//     driver.findElement(By.xpath("//button[@title='Update Shopping Cart']")).click();
//     Thread.sleep(5000);
//   //  String cartValue=driver.findElement(By.xpath("(//td[@class='amount']) [3]")).getText();
//  //   Assert.assertEquals("$185.80",cartValue);
//  //   System.out.println("Value Match");
////     a.scrollByAmount(0, 500);
//     a.moveToElement(driver.findElement(By.xpath("(//li[@class='item']) [1]"))).click().build().perform();   //proceed to checkout
//
//     Thread.sleep(2000);
//     //company Name
//     driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[1]/div[1]/div[3]/div[1]/input[1]")).sendKeys("BBD");
//     Thread.sleep(1000);
//     //Address
//     driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[1]/div[1]/fieldset[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("Moraj");
//     //city
//     Thread.sleep(1000);
//     driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[1]/div[1]/div[4]/div[1]/input[1]")).sendKeys("San Diego");
//     Thread.sleep(1000);
//     WebElement region=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[1]/div[1]/div[5]/div[1]/select[1]"));
//     Select menu=new Select(region);
//     menu.selectByVisibleText("California");
//     Thread.sleep(1000);
//     driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[1]/div[1]/div[7]/div[1]/input[1]")).sendKeys("96162");
//     WebElement Country=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[1]/div[1]/div[8]/div[1]/select[1]"));
//     Select menu2= new Select(Country);
//     menu2.selectByVisibleText("United States");
//     driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[1]/div[1]/div[9]/div[1]/input[1]")).sendKeys("8097602560");
//     driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[2]/div[1]/div[3]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")).click();
//     driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[2]/div[1]/div[3]/form[1]/div[3]/div[1]/button[1]/span[1]")).click();
//     Thread.sleep(5000);
  //   Step 19 and 20 Remaining
	}

}
